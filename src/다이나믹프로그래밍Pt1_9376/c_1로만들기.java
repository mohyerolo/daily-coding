package 다이나믹프로그래밍Pt1_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c_1로만들기 {
    private static int N;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        System.out.println(calcMin(N, 0));
    }

    private static int calcMin(int x, int cnt) {
        if (x < 2) return cnt;
        return Math.min(calcMin(x / 2, cnt + 1 + (x % 2)),
         calcMin(x / 3, cnt + 1 + (x % 3)));
    }
}