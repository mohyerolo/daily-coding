package 브루트포스_9373_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c_암호만들기 {
    private static int L, C;
    private static char[] arr;
    private static char[] given;
    private static boolean[] vowel;
    
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[L];
        given = new char[C];
        vowel = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            given[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(given);
        for (int i = 0; i < C; i++) {
            char c = given[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel[i] = true;
            }
        }

        dfs(0, 0, 0, 0);
        System.out.println(sb);
    }    

    private static void dfs(int num, int depth, int consonants, int vowels) {
        if (depth == L) {
            if (consonants > 1 && vowels > 0) {
                for (char a : arr) {
                    sb.append(a);
                }
                sb.append('\n');
            }   
            return;
        }

        for (int i = num; i < C; i++) {
            arr[depth] = given[i];
            if (vowel[i]) {
                dfs(i + 1, depth + 1, consonants, vowels + 1);
            } else {
                dfs(i + 1, depth + 1, consonants + 1, vowels);
            }
        }
    }
}
