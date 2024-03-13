package 브루트포스_9372_N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_NM과K_1_2 {
    private static int N, M, K;
    private static int max = Integer.MIN_VALUE;
    private static int[][] arr;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(1, 1, 0, 0);
        System.out.println(max);
    }

    private static void backTracking(int row, int col, int cnt, int sum) {
        if (cnt == K) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = row; i < N + 1; i++) {
            for (int j = (i == row ? col : 1); j < M + 1; j++) {
                if (!visit[i][j] && !borderOnSpace(i, j)) {
                    visit[i][j] = true;
                    backTracking(i, j, cnt + 1, sum + arr[i][j]);
                    visit[i][j] = false;
                }
            }
        }
    }

    private static boolean borderOnSpace(int y, int x) {
        if (visit[y][x - 1] || visit[y - 1][x]) return true;
        return false;
    }
}