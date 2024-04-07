package 다이나믹프로그래밍Pt1_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_가장긴증가하는부분수열 {
    private static int N;
    private static int[] dp;
    private static int[] arr;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = N - 1; i > 0; i--) {
            dp[i] = findSeq(i);
        }

        int max  = dp[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private static int findSeq(int n) {
        if (dp[n] == 0) {
            dp[n] = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (arr[n] > arr[i]) {
                    dp[n] = Math.max(dp[n], findSeq(i) + 1);
                }
            }
        }
        return dp[n];
    }
}
