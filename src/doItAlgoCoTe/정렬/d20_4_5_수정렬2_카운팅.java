package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2751
public class d20_4_5_수정렬2_카운팅 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[2000001];
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if  (arr[i] > 0) {
                sb.append(i - 1000000).append('\n');
            }
        }

        System.out.println(sb);
    }    
}
