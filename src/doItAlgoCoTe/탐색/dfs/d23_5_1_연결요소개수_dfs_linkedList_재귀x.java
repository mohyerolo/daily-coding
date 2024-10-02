package doItAlgoCoTe.탐색.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11724
// LinkedList를 이용한 재귀가 없는 풀이
public class d23_5_1_연결요소개수_dfs_linkedList_재귀x {
    private static int N;
    private static boolean[][] map;
    private static boolean[] visit;
    private static int cnt = 0;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[s][e] = map[e][s] = true;
        }

        findConnectedComponent();

        System.out.println(cnt);
    }

    private static void findConnectedComponent() {        
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                cnt++;
                dfs(i);
            }
        }
    }

    private static void dfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visit[v] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 1; i < N + 1; i++) {
                if (map[num][i] && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
