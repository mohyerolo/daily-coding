package 브루트포스_9372_N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_N과M_1 {
    private static int N, M;
    private static int[] arr;
    private static boolean[] visit;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N + 1];

        dfs(0);
        System.out.println(sb);
    }    

    private static void dfs(int depth) {
        if (depth == M) {
            for (int a : arr) {
                sb.append(a).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                arr[depth] = i;
                visit[i] = true;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
