package 브루트포스_9375_비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_종이조각 {
    private static int N, M;
    private static int[][] arr;
    private static boolean[][] visit;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];

        String str = "";
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }    

    private static void dfs(int row, int col) {
        if (row >= N) {
            sum();
            return;
        }

        if (col >= M) {
            dfs(row + 1, 0);
            return;
        }

        visit[row][col] = true;
        dfs(row, col + 1);
        visit[row][col] = false;
        dfs(row, col + 1);
    }

    private static void sum() {
        int sum = 0;
        int num;

        for (int i = 0; i < N; i++) {
            num = 0;
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) {
                    num *= 10;
                    num += arr[i][j];
                } else {
                    sum += num;
                    num = 0;
                }
            }
            sum += num;
        }

        for (int j = 0; j < M; j++) {
            num = 0;
            for (int i = 0; i < N; i++) {
                if (!visit[i][j]) {
                    num *= 10;
                    num += arr[i][j];
                } else {
                    sum += num;
                    num = 0;
                }
            }
            sum += num;
        }

        max = Math.max(max, sum);
    }
}
