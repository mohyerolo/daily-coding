package 브루트포스_9375_비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_집합 {
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int S = 0;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            categorize(br.readLine());
        }
        System.out.println(sb);
    }    

    private static void categorize(String sentence) {
        st = new StringTokenizer(sentence);
        String str = st.nextToken();

        switch (str) {
            case "all": S = (1 << 21) - 1; break;
            case "empty": S = 0; break;
            default:
                int num = Integer.parseInt(st.nextToken());
                calc(str, num);
                break;
        }
    }

    private static void calc(String str, int num) {
        switch (str) {
            case "add": S |= (1 << num); break;
            case "remove": S &= ~(1 << num); break;
            case "toggle": S ^= (1 << num); break;
            case "check": sb.append((S & (1 << num)) != 0 ? 1 : 0).append('\n'); break;
        }
    }
}
