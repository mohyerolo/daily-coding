package doItAlgoCoTe.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10986
public class d5_3_2_나머지합 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long cnt = 0;

        long[] S = new long[N + 1];
        // int[] modCnt일때는 안 되고 long으로 바꾸니까 됨. 왜지
        long[] modCnt = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = S[i- 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int mod = (int)(S[i] % M);
            if (mod == 0) cnt++;
            modCnt[mod]++;
        }

        for (int i = 0; i < M; i++) {
            if (modCnt[i] > 1) {
                cnt += (modCnt[i] * (modCnt[i] - 1)) / 2;
            }
        }
        System.out.println(cnt);
    }
}