package doItAlgoCoTe.탐색.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1260
// 책에서 나온 풀이
public class d26_DFS와BFS_ArrayList {
    private static boolean[] visit;
    private static ArrayList<Integer>[] A;
    private static StringBuilder sb = new StringBuilder();

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];

        A = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(A[i]);
        }

        dfs(V);
        sb.append('\n');

        visit = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }    

    private static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(' ');
        for (int i : A[start]) {
            if (!visit[i]) dfs(i);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int value = queue.poll();
            sb.append(value).append(' ');
            for (int i : A[value]) {
                if (!visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
