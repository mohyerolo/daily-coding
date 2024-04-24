package 다이나믹프로그래밍Pt1_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c_합분해 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][N + 1];
        Arrays.fill(dp[1], 1);
        for (int i = 1; i < K + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 2; i < K + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }
        System.out.println(dp[K][N]);
    }
}
