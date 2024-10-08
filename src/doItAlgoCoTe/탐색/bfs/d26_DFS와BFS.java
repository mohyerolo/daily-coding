package doItAlgoCoTe.탐색.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1260
public class d26_DFS와BFS {
    private static int N;
    private static boolean[][] map;
    private static boolean[] visit;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());     
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = true;
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
        for (int i = 0; i < N + 1; i++) {
            if (!visit[i] && map[start][i]) dfs(i);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int value = queue.poll();
            sb.append(value).append(' ');
            for (int i = 1; i < N + 1; i++) {
                if (!visit[i] && map[value][i]) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
