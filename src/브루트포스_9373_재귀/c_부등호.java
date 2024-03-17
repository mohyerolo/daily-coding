package 브루트포스_9373_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class c_부등호 {
    private static int k;
    private static char[] sign;
    private static int[] arr;
    private static boolean[] visit;

    private static List<String> numList = new ArrayList<>();
    // 리스트 사용이 long.parseLong으로 수 변경 -> 비교보다 빠름.
    // private static String minString, maxString;
    // private static Long min = Long.MAX_VALUE;
    // private static Long max = 0L;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        sign = new char[k];
        arr = new int[k + 1];
        visit = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        dfs("", 0);

        System.out.println(numList.get(numList.size() - 1));
        System.out.println(numList.get(0));
    }    

    private static void dfs(String sum, int depth) {
        if (depth == k + 1) {
            numList.add(sum);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                if (depth == 0 || compareNum(arr[depth - 1], i, sign[depth - 1])) {
                    visit[i] = true;
                    arr[depth] = i;
                    dfs(sum + i, depth + 1);
                    visit[i] = false;                    
                }
            }
        }
    }

    private static boolean compareNum(int before, int now, char sign) {
        if (sign == '<' && before >= now) return false;
        if (sign == '>' && before <= now) return false;
        return true;
    }
}
