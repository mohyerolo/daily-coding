package doItAlgoCoTe.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d7_3_3_주몽 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int i = 0;
        int j = N - 1;
        int cnt = 0;
        while (i < j) {
            int val = arr[i] + arr[j];
            if (val == M) {
                cnt++;
                i++; j--;
            } else if (val < M) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(cnt);
    }
}
