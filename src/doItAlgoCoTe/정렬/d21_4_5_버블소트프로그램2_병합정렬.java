package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1517
public class d21_4_5_버블소트프로그램2_병합정렬 {
    private static int[] A;
    private static int[] tmp;
    private static long cnt;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        tmp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(1, N);
        System.out.println(cnt);
    }

    private static void merge_sort(int s, int e) {
        if (e - s < 1) return;
        int m = s + (e - s) / 2;

        merge_sort(s, m);
        merge_sort(m + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }

        int left = s;
        int now = s;
        int right = m + 1;

        while (left <= m && right <= e) {
            if (tmp[left] > tmp[right]) {
                cnt += right - now;
                A[now++] = tmp[right++];
            } else {
                A[now++] = tmp[left++];
            }
        }

        while (left <= m) {
            A[now++] = tmp[left++];
        }
        while (right <= e) {
            A[now++] = tmp[right++];
        }
    }
}