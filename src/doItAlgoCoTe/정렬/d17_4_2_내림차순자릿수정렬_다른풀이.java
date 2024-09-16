package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d17_4_2_내림차순자릿수정렬_다른풀이 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] cnt = new int[10];
        int num = Integer.parseInt(br.readLine());
        while (num > 0) {
            cnt[num % 10]++;
            num /= 10;
        }

        for (int i = 9; i >= 0; i--) {
            while (cnt[i]-- > 0) {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}
