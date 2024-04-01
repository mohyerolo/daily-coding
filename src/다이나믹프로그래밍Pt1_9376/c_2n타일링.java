package 다이나믹프로그래밍Pt1_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c_2n타일링 {
    private static int[] dp;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        dp[1] = 1;
        if (N > 1) {
            dp[2] = 2;
        }
        System.out.println(calc(N));
    }    

    private static int calc(int N) {
        if (dp[N] == 0) {
            dp[N] = (calc(N - 1) + calc(N - 2)) % 10007;
        }
        return dp[N];
    }
}
