package doItAlgoCoTe.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1546
// https://www.acmicpc.net/problem/1546
public class d2_3_1_평균구하기 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int originalScore = 0;
        int M = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            M = M < val ? val : M;
            originalScore += val;
        }

        System.out.println((double)(originalScore * 100 / M) / N);
    }
}
