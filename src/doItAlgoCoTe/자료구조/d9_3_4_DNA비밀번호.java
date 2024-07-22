package doItAlgoCoTe.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/12891
public class d9_3_4_DNA비밀번호 {
    private static int S, P;
    private static char[] arr;
    // A C G T
    private static int[] given = new int[4];
    private static int[] select = new int[4];
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            given[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getAvailableDNAStringNum());
    }

    private static int getAvailableDNAStringNum() {
        int num = 0;
        if (initializeFirst()) num++;

        for (int i = 1; i < S - P + 1; i++) {
            Remove(i - 1);
            Add(i + P - 1);
            if (check()) num++;
        }
        return num;
    }

    private static boolean initializeFirst() {
        for (int i = 0; i < P; i++) {
            Add(i);
        }
        if (!check()) return false;
        return true;
    }

    private static void Add(int index) {
        char dna = arr[index];
        switch (dna) {
            case 'A': select[0]++;break;
            case 'C': select[1]++; break;
            case 'G': select[2]++; break;
            case 'T': select[3]++; break;
        }
    }

    private static void Remove(int pre) {
        char dna = arr[pre];
        switch (dna) {
            case 'A': select[0]--; break;
            case 'C': select[1]--; break;
            case 'G': select[2]--; break;
            case 'T': select[3]--; break;
        }
    }

    private static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (given[i] > select[i]) return false;
        }
        return true;
    }
}