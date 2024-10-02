package doItAlgoCoTe.탐색.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d24_5_1_신기한소수_isPrime수정 {
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    
        System.out.println(sb);
    }    

    private static void dfs(int num, int jarisu) {
        if (jarisu == N) {
            sb.append(num).append('\n');
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) continue;
            if (isPrime(num * 10 + i)) dfs(num * 10 + i, jarisu + 1);
        }

    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
