package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2751
public class d20_4_5_수정렬2_병합정렬 {
    private static int[] arr;
    private static int[] tmp;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tmp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void merge_sort(int s, int e) {
        if (e - s < 1) {
            return;
        }

        int m = s + (e - s) / 2;

        merge_sort(s, m);
        merge_sort(m + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }

        int left = s;
        int right = m + 1;
        int now = s;
        while (left <= m && right <= e) {
            if (tmp[left] < tmp[right]) {
                arr[now++] = tmp[left++];
            } else {
                arr[now++] = tmp[right++];
            }
        }

        while (left <= m) {
            arr[now++] = tmp[left++];
        }

        while (right <= e) {
            arr[now++] = tmp[right++];
        }
    }
}
