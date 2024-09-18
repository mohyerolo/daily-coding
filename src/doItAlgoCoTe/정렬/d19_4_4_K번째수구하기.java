package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11004
public class d19_4_4_K번째수구하기 {
    private static int K;
    private static int[] arr;
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quick_sort(0, N - 1);
        System.out.println(arr[K - 1]);
    }

    private static void quick_sort(int l, int r) {
        if (l < r) {
            int pivot = partition(l, r);
            if (pivot == K - 1) return;
            else if (K - 1 < pivot) quick_sort(l, pivot - 1);
            else quick_sort(pivot + 1, r);
        }
    }

    private static int partition(int left, int right) {
        if (left + 1 == right) {
            if (arr[left] > arr[right]) swap(left, right);
            return right;
        }

        int m = (left + right) / 2;
        swap(left, m);

        int p = arr[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (j >= left + 1 && p < arr[j]) j--;
            while (i <= right && p > arr[i]) i++;
            if (i <= j) {
                swap(i++, j--);
            }
        }

        arr[left] = arr[j];
        arr[j] = p;
        return j;
    }

    private static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
