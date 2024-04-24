package 다이나믹프로그래밍Pt1_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_퇴사 {
    private static int[] dp;
    private static int[] T;
    private static int[] P;
    private static int N;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        dp = new int[N + 1];
        T = new int[N + 1];
        P = new int[N + 1];

        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            if (T[i] + i <= N + 1) {
                dp[(i + T[i]) - 1] = Math.max(dp[(i + T[i]) - 1], dp[i - 1] + P[i]);
            }
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }
        
        System.out.println(dp[N]);
    }    
}
