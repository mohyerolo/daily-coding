package 다이나믹프로그래밍Pt1_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_카드구매하기 {
    private static int N;
    private static int[] dp, cost;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        cost = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = cost[1];
        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cost[j]);
            }
        }

        System.out.println(dp[N]);
    }    
}
