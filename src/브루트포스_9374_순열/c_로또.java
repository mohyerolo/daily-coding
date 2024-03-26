package 브루트포스_9374_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_로또 {
    private static int k;
    private static int[] input;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            initialize(st);
            
            dfs(0, 0);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void initialize(StringTokenizer st) {
        input = new int[k];
        arr = new int[6];
        for (int i = 0; i < k; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void dfs(int depth, int now) {
        if (depth == 6) {
            for (int a : arr) {
                sb.append(a).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = now; i < k; i++) {
            arr[depth] = input[i];
            dfs(depth + 1, i + 1);
        }
    }
}
