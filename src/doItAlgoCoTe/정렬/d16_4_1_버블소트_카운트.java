package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d16_4_1_버블소트_카운트 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[1000001];
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            cnt[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < cnt.length; i++) {
            index += cnt[i];
            if (cnt[i] > 0) cnt[i] = index - 1;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = max < i - cnt[arr[i]] ? i - cnt[arr[i]] : max;
        }
        System.out.println(max + 1);
    }    
}
