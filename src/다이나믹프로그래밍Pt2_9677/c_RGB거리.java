package 다이나믹프로그래밍Pt2_9677;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_RGB거리 {
    private static int N;
    private static int rgb[][];
    private static int dp[][];

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rgb = new int[N][3];
        dp = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];

        System.out.println(Math.min(calcRGB(N - 1, 0), 
            Math.min(calcRGB(N - 1, 1), calcRGB(N - 1, 2))));

    }

    private static int calcRGB(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == 0) {
                dp[n][color] = Math.min(calcRGB(n - 1, 1), calcRGB(n - 1, 2));
            } else if (color == 1) {
                dp[n][color] = Math.min(calcRGB(n - 1, 0), calcRGB(n - 1, 2));
            } else {
                dp[n][color] = Math.min(calcRGB(n - 1, 0), calcRGB(n - 1, 1));
            }
            dp[n][color] += rgb[n][color];
        }
        return dp[n][color];
    }

    
}
