package doItAlgoCoTe.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1546
// https://www.acmicpc.net/problem/11660
public class d4_3_2_구간합구하기2 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] sum = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i- 1][j] - sum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int x1, x2, y1, y2, result;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
