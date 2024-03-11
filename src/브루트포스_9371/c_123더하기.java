package 브루트포스_9371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c_123더하기 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[12];
        dp[1] = 1;  // 1
        dp[2] = 2;  // 1 + 1, 2
        dp[3] = 4;  // 1 + 1 + 1, 1 + 2, 2 + 1, 3
        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        for (int i = 0; i < T; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }

        System.out.println(sb);
    }    
}
