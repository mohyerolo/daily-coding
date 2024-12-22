package doItAlgoCoTe.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class d29_2_원하는정수찾기_Map {
    private static Map<Integer, Boolean> A = new HashMap<>();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.put(Integer.parseInt(st.nextToken()), true);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(getResult(Integer.parseInt(st.nextToken()))).append('\n');
        }
        System.out.println(sb);
    }

    private static int getResult(final int condition) {
        if (A.containsKey(condition)) {
            return 1;
        }
        return 0;
    }
}
