package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11399
public class d18_4_3_ATM인출 {
    private static int N;
    private static int[] P;
    private static int insertIndex;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int insertValue;
        for (int i = 1; i < N; i++) {
            insertIndex = i;
            insertValue = P[i];

            findIndex(i);
            makeNewSortedArray(i);

            P[insertIndex] = insertValue;
        }

        int sum = 0;
        int min = 0;
        for (int i = 0; i < N; i++) {
            sum += P[i];
            min += sum;
        }

        System.out.println(min);
    }

    private static void findIndex(int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (P[j] < P[i]) {
                insertIndex = j + 1; 
                break;
            } 
            if (j == 0) insertIndex = 0;
        }
    }

    private static void makeNewSortedArray(int i) {
        for (int j = i; j > insertIndex; j--) {
            P[j] = P[j - 1];
        }
    }
}
