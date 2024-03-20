
package 브루트포스_9374_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_이전순열 {
    private static int N;
    private static int[] arr;
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        if (prePermutation()) {
            for (int a : arr) sb.append(a).append(' ');
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean prePermutation() {
        int i = N - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) i--;
        if (i <= 0) return false;
        
        int j = N - 1;
        while (arr[j] >= arr[i - 1]) j--;
        if (j <= 0) return false;

        swap(i - 1, j);
        j = N - 1;
        while(i < j) {
            swap(i++, j--);
        }
        return true;
    }

    private static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
