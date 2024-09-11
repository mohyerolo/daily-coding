package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d15_4_1_수정렬1_카운트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[] cnt = new boolean[2001];

        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(br.readLine()) + 1000] = true;
        }

        for (int i = 0; i < 2001; i++) {
            if (cnt[i]) sb.append(i - 1000).append('\n');
        }
        System.out.println(sb.toString());
    }
}
