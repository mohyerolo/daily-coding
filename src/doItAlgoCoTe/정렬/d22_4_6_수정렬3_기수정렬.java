package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10989
// 구간 합을 이용한 기수정렬
public class d22_4_6_수정렬3_기수정렬 {
    private static int[] A;
    private static int N;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        radix_sort();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append('\n');
        }
        System.out.println(sb);
    }   
    
    private static void radix_sort() {
        int[] output = new int[N];
        int now = 0;
        int jarisu = 1;
        while (now++ < 5) {   // 최대가 10000보다 작거나 같음, 최대 자릿수는 5
            int[] bucket = new int[10]; // 0~9까지 담을 배열
            for (int i = 0; i < N; i++) {
                bucket[(A[i] / jarisu) % 10]++; // 자릿수의 마지막 값을 알아내는 것
            }

            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (int i = N - 1; i >= 0; i--) {
                int AValue = (A[i] / jarisu) % 10;
                output[bucket[AValue] - 1] = A[i];
                bucket[AValue]--;
            }

            for (int i = 0; i < N; i++) {
                A[i] = output[i];
            }

            jarisu *= 10;
        }
    }
}
