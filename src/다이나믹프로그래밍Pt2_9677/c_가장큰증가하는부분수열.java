package 다이나믹프로그래밍Pt2_9677;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_가장큰증가하는부분수열 {
    private static int N;
    private static int[] arr;
    private static int[] dp;
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        for (int i = N - 1; i > 0; i--) {
            if (dp[i] == 0) {
                dp[i] = findSum(i);
            }
        }

        System.out.println(findMax());
    }   
    
    private static int findSum(int N) {
        if (dp[N] == 0) {
            dp[N] = arr[N];
            for (int i = N - 1; i >= 0; i--) {
                if (arr[N] > arr[i]) {
                    dp[N] = Math.max(dp[N], findSum(i) + arr[N]);
                }
            }
        }
        return dp[N];
    }

    private static int findMax() {
        int max = dp[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
