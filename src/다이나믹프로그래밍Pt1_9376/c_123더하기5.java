package 다이나믹프로그래밍Pt1_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c_123더하기5 {
    private static int N;
    private static Long[][] dp;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += find(N, i);
        }

        System.out.println(result % 1000000000);
    }    

    private static Long find(int digit, int num) {
        if (dp[digit][num] == null) {
            if (num == 0) dp[digit][num] = find(digit - 1, 1);
            else if (num == 9) dp[digit][num] = find(digit - 1, 8);
            else dp[digit][num] = find(digit - 1, num - 1) + find(digit - 1, num + 1);
        }
        return dp[digit][num] % 1000000000;
    }
}
