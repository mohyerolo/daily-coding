package 다이나믹프로그래밍Pt2_9677;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_가장긴바이토닉부분수열 {
    private static int N;
    private static int[] arr;
    private static int[] ascendingOrder, descendingOrder;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ascendingOrder = new int[N];
        descendingOrder = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            findAscendingOrder(i);
            findDescendingOrder(i);
        }

        int max = ascendingOrder[0] + descendingOrder[0];
        for (int i = 1; i < N; i++) {
            int num = ascendingOrder[i] + descendingOrder[i];
            max = max < num ? num : max;
        }

        System.out.println(max - 1);
    }

    private static int findAscendingOrder(int n) {
        if (ascendingOrder[n] == 0) {
            ascendingOrder[n] = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    ascendingOrder[n] = Math.max(ascendingOrder[n], findAscendingOrder(i) + 1);
                }
            }
        }
        return ascendingOrder[n];
    }

    private static int findDescendingOrder(int n) {
        if (descendingOrder[n] == 0) {
            descendingOrder[n] = 1;
            for (int i = n + 1; i < N; i++) {
                if (arr[i] < arr[n]) {
                    descendingOrder[n] = Math.max(descendingOrder[n], findDescendingOrder(i) + 1);
                }
            }
        }
        return descendingOrder[n];
    }
}