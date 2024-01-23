package 브루트포스_9371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c_사탕게임 {
    private static int N;
    private static byte[][] arr;
    private static int max = 1;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new byte[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().getBytes();
        }

        executeAllCase();
        System.out.println(max);
    }    

    private static void executeAllCase() {
        swapCol();
        swapRow();        
    }

    private static void swapCol() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                checkColSwapEffect(i, j);
                swap(i, j, i, j + 1);
            }
        }
    }

    private static void swapRow() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                checkRowSwapEffect(i, j);
                swap(i, j, i + 1, j);
            }
        }
    }

    private static void swap(int x, int y, int x2, int y2) {
        byte temp = arr[x][y];
        arr[x][y] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    private static void checkColSwapEffect(int row, int col) {
        int cnt = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            cnt = (arr[row][i] == arr[row][i + 1]) ? cnt + 1 : 1;
            if (cnt != 1) max = Math.max(max, cnt);
        }

        cnt = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            cnt = (arr[i][col] == arr[i + 1][col]) ? cnt + 1 : 1;
            if (cnt != 1) max = Math.max(max, cnt);
        }

        cnt = 1;
        if (col + 1 < arr.length) {
            for (int i = 0; i < arr.length - 1; i++) {
                cnt = (arr[i][col + 1] == arr[i + 1][col + 1]) ? cnt + 1 : 1;
                if (cnt != 1) max = Math.max(max, cnt);
            }
        }
    }

    private static void checkRowSwapEffect(int row, int col) {
        int cnt = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            cnt = (arr[i][col] == arr[i + 1][col]) ? cnt + 1 : 1;
            if (cnt != 1) max = Math.max(max, cnt);
        }

        cnt =  1;
        for (int i = 0; i < arr.length - 1; i++) {
            cnt = (arr[row][i] == arr[row][i + 1]) ? cnt + 1 : 1;
            if (cnt != 1) max = Math.max(max, cnt);
        }

        cnt = 1;
        if (row + 1 < arr.length) {
            for (int i = 0; i < arr.length - 1; i++) {
                cnt = (arr[row + 1][i] == arr[row + 1][i + 1]) ? cnt + 1 : 1;
                if (cnt != 1) max = Math.max(max, cnt);
            }
        }
    }
}
