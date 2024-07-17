package doItAlgoCoTe.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1253
public class d8_3_3_좋은수 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int num = A[i];
            int start = 0;
            int end = N - 1;
            while (start < end) {
                int val = A[start] + A[end];
                if (val == num) {
                    if (start != i && end != i) {
                        cnt++;
                        break;
                    } else if (start == i) start++;
                    else end--;

                } else if (val < num) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(cnt);
    }    
}
