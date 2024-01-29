package 브루트포스_9371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_리모콘 {
    private static boolean[] numbers;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());
        if (M != 0) {
            numbers = new boolean[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                numbers[Integer.parseInt(st.nextToken())] = true;
            }
        }

        if (N == 100) {
            System.out.println(0);
            return;
        }

        int cnt = findLowestCnt(N, M);
        System.out.println(cnt);
    }    

    private static int findLowestCnt(int N, int M) {
        int onlyPlusOrMinusCnt = Math.abs(N - 100);
        if (M == 0) {
            return Math.min(onlyPlusOrMinusCnt, String.valueOf(N).length());
        } else if (M == 10) {
            return onlyPlusOrMinusCnt;
        }
        return checkAllCandidates(N, onlyPlusOrMinusCnt);
    }

    private static int checkAllCandidates(int N, int onlyPlusOrMinusCnt) {
        int cnt = onlyPlusOrMinusCnt;

        for (int i = 0; i < 1000000; i++) {
            String target = String.valueOf(i);
            int len = target.length();
            if (justPressTheNum(target, len)) {
                int min = Math.abs(N - i) + len;
                cnt = Math.min(cnt, min);
            }
        }
        return cnt;
    }

    private static boolean justPressTheNum(String target, int len) {
        for (int i = 0; i < len; i++) {
            if (numbers[target.charAt(i) - '0']) return false;
        }
        return true;
    }
}
