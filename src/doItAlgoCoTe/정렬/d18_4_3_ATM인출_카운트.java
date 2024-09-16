package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11399
public class d18_4_3_ATM인출_카운트 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cnt = new int[1001];
        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(st.nextToken())]++;
        }

        int sum = 0;
        int min = 0;
        for (int i = 1; i < 1001; i++) {
            while (cnt[i]-- > 0) {
                sum += i;
                min += sum;
            }
        }
        System.out.println(min);
    }
}
