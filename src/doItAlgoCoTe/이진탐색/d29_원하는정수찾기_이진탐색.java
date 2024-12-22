package doItAlgoCoTe.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1920
// doIt알고리즘 p182
public class d29_원하는정수찾기_이진탐색 {
    private static int[] A;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int condition = Integer.parseInt(st.nextToken());
            sb.append(findResult(condition)).append('\n');
        }
        System.out.println(sb);
    }

    private static int findResult(final int condition) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int value = A[mid];
            if (value < condition) {
                start = mid + 1;
            } else if (value > condition) {
                end = mid - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }

}
