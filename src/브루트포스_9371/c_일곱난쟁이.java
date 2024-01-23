package 브루트포스_9371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class c_일곱난쟁이 {
    private static int[] heights = new int[9];
    private static StringBuilder sb = new StringBuilder();
    private static int wrong1 = 0;
    private static int wrong2 = 0;
    private static int sum = 0;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        Arrays.sort(heights);
        findWrongHeights();
        appendHeights();
        System.out.println(sb);
    }

    private static void findWrongHeights() {
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (sum - heights[i] - heights[j] == 100) {
                    wrong1 = heights[i];
                    wrong2 = heights[j];
                    return;
                }
            }
        }
    }

    private static void appendHeights() {
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != wrong1 && heights[i] != wrong2) {
                sb.append(heights[i]).append('\n');
            }
        }
    }
}
