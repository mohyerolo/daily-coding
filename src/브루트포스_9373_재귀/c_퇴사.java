package 브루트포스_9373_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_퇴사 {
    private static int N;
    private static int[] days, costs, dp;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        days = new int[N];
        costs = new int[N];
        dp = new int[N + 1];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }

        findMax();

        System.out.println(dp[N]);
    }

    private static void findMax() {
        for (int i = 0; i < N; i++) {
            if (days[i] + i < N + 1) {
                dp[i + days[i]] = Math.max(dp[i + days[i]], dp[i] + costs[i]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
    }
}
