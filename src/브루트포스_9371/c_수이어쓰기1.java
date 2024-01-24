package 브루트포스_9371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c_수이어쓰기1 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 10) {
            System.out.println(N);
            return;
        }
        
        int size = 9;
        int maxLength = String.valueOf(N).length();
        int min = 10;
        int max;

        for (int i = 2; i < maxLength + 1; i++) {
            if (i == maxLength) {
                max = N;
            } else {
                max = min * 10 - 1;
            }
            size += (max - min + 1) * i;
            min *= 10;
        }
        System.out.println(size);

    }    
}
