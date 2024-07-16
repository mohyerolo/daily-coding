package doItAlgoCoTe.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 11720
// https://www.acmicpc.net/problem/11720
public class d1_3_1_숫자의합구하기 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (byte b : br.readLine().getBytes()) {
            sum += b -'0';
        }
        System.out.println(sum);
    }
}