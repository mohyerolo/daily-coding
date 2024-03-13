package 브루트포스_9371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_테트로미노 {
    private static int[][] arr;
    private static boolean[][] visit;
    private static int n, m;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                solve(i, j, arr[i][j], 1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void solve(int y, int x, int sum, int cnt) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int row = y + dy[i];
            int col = x + dx[i];

            if (!checkRowAndCol(row,col)) {
                continue;
            }

            if (!visit[row][col]) {
                if (cnt == 2) {
                    visit[row][col] = true;
                    solve(y, x, sum + arr[row][col], cnt + 1);
                    visit[row][col] = false;
                }

                visit[row][col] = true;
                solve(row, col, sum + arr[row][col], cnt + 1);
                visit[row][col] = false;
            }
        }
    }

    private static boolean checkRowAndCol(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m) return false;
        return true;
    }
}
