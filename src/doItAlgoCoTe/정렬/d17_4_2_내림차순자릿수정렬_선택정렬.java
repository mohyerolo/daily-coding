package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1427
public class d17_4_2_내림차순자릿수정렬_선택정렬 {
    private static byte[] arr;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().getBytes();
        StringBuilder sb = new StringBuilder();

        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[max]) max = j;
            }
            if (arr[i] < arr[max]) {
                swap(i, max);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] - 48);
        }
        System.out.println(sb);
    }
    private static void swap(int a, int b) {
        byte temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}