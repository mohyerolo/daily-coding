package 다이나믹프로그래밍Pt1_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_연속합 {
    private static int[] arr;
    private static Integer[] dp;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = dp[0];
        for (int i = N - 1; i >= 0; i--) {
            max = Math.max(max, findMax(i));
        }

        System.out.println(max);
    }    

    private static int findMax(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(arr[N], findMax(N - 1) + arr[N]);
        }
        return dp[N];
    }
}
