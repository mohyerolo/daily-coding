package 다이나믹프로그래밍Pt2_9677;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c_포도주시식 {
    private static int n;
    private static int[] arr, dp;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[i] = -1;
        }

        dp[1] = arr[1];
        if (n > 1) dp[2] = arr[1] + arr[2];

        System.out.println(findMax(n));
    }    

    private static int findMax(int n) {
        if (n < 1) return 0;

        if (dp[n] == -1) {
            dp[n] = Math.max(findMax(n - 1), 
                        Math.max(findMax(n - 2), findMax(n - 3) + arr[n - 1]) + arr[n]);
        }
        return dp[n]; 
    }
}
