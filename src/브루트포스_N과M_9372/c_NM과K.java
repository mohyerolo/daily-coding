package 브루트포스_N과M_9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_NM과K {
    private static int N, M, K;
    private static int max = Integer.MIN_VALUE;
    private static int[][] arr;
    private static boolean[][] visit;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0, 0, 0);
        System.out.println(max);
    }

    private static void backTracking(int row, int col, int cnt, int sum) {
        if (cnt == K) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = row; i < N; i++) {
            for (int j = (i == row ? col : 0); j < M; j++) {
                if (!visit[i][j] && !borderOnSpace(i, j)) {
                    visit[i][j] = true;
                    backTracking(i, j + 1, cnt + 1, sum + arr[i][j]);
                    visit[i][j] = false;
                }
            }
        }
    }

    private static boolean borderOnSpace(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int row = dy[i] + y;
            int col = dx[i] + x;
        
            if (checkLimit(row, col)) {
                if (visit[row][col]) return true;
            }
        }
        return false;
    }

    private static boolean checkLimit(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= M) return false;
        return true;
    }
}
