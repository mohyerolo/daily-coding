package 브루트포스_9373_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_링크와스타트 {
    private static int N;
    private static int[][] arr;
    private static int min = Integer.MAX_VALUE;
    private static int member;

    private static boolean[] visit;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visit = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (member = 1; member < N; member++) {
            divideTeams(0, 0);
        }
        System.out.println(min);
    } 
    
    private static void divideTeams(int num, int depth) {
        if (depth == member) {
            calcDifference();
            return;
        }

        for (int i = num; i < N; i++) {
            visit[i] = true;
            divideTeams(i + 1, depth + 1);
            visit[i] = false;
        }
    }

    private static void calcDifference() {
        int teamStart = 0;
        int teamLink = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    teamStart += (arr[i][j] + arr[j][i]);
                } else if (!visit[i] && !visit[j]) {
                    teamLink += (arr[i][j] + arr[j][i]);
                }
            }
        }
        min = Math.min(Math.abs(teamStart - teamLink), min);
        if (min == 0) {
            System.out.println(0);
            System.exit(0);
        }
    }
}
