package 브루트포스_9373_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c_Guess {
    private static int n;
    private static int[] arr;
    private static char[][] matrix;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        char[] sign = br.readLine().toCharArray();
        matrix = new char[n][n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                matrix[i][j] = sign[index++];
            }
        }

        dfs(0);
    }    

    private static void dfs(int depth) {
        if (depth == n) {
            for (int a : arr) {
                sb.append(a).append(' ');
            }
            System.out.println(sb);
            System.exit(0);
        }

        for (int i = -10; i <= 10; i++) {
            arr[depth] = i;
            if (sumEqSign(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean sumEqSign(int depth) {
        int sum;
        for (int i = 0; i < depth + 1; i++) {
            sum = 0;
            for (int j = i; j < depth + 1; j++) {
                sum += arr[j];
                if (matrix[i][j] != (sum == 0 ? '0' : (sum < 0 ? '-' : '+'))) {
                    return false;
                }
            }
        }
        return true;
    }
}
