package 브루트포스_9371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_카잉달력 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M, N, x, y;
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sb.append(findYear(M, N, x, y)).append('\n');
        }

        System.out.println(sb);
    }    

    private static int findYear(int M, int N, int x, int y) {
        int year = x;
        int lastYear = M * N / GCD(M, N);
        while (true) {
            if (year > lastYear) {
                return -1;
            }
            int tempY = year % N == 0 ? N : year % N;
            if (tempY == y) return year;
            year += M;
        }
    }

    private static int GCD(int A, int B) {
        int temp;
        while (B > 0) {
            temp = A % B;
            A = B;
            B = temp;
        }
        return A;
    }

}
