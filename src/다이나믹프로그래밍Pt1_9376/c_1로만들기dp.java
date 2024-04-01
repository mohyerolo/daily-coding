package 다이나믹프로그래밍Pt1_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c_1로만들기dp {
    private static int N;
    private static int[] dp;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = -1;
        }

        dp[0] = dp[1] = 0;

        System.out.println(calcMin(N));
    }    

    private static int calcMin(int N) {
        if (dp[N] == -1) {
            if (N % 6 == 0) {
                dp[N] = Math.min(calcMin(N - 1), Math.min(calcMin(N / 3), calcMin(N / 2))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(calcMin(N - 1), calcMin(N / 3)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(calcMin(N - 1), calcMin(N / 2)) + 1;
            } else {
                dp[N] = calcMin(N - 1) + 1;
            }
        }
        return dp[N];
    }

}
