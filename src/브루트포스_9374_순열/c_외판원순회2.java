package 브루트포스_9374_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_외판원순회2 {
    private static int N;
    private static int[][] w;
    private static boolean[] visit;

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        w = new int[N][N];
        visit = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visit[i] = true;
            dfs(0, i, i, 0);
        }

        System.out.println(min);
    }

    private static void dfs(int depth, int prev, int start, int cost) {
        if (depth == N - 1) {
            if (w[prev][start] != 0) {
                cost += w[prev][start];
                min = Math.min(cost, min);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i] && w[prev][i] != 0) {
                visit[i] = true;
                dfs(depth + 1, i, start, cost + w[prev][i]);
                visit[i] = false;
            }
        }
    }
}
