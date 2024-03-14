package 브루트포스_9373_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_스타트와링크 {
    private static int N;
    private static int[][] arr;
    private static int min = Integer.MAX_VALUE;

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

        divideTeams(0, 0);
        System.out.println(min);
    }

    private static void divideTeams(int num, int depth) {
        if (depth == N / 2) {
            calcDifference();            
            if (min == 0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for (int i = num; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                divideTeams(i + 1, depth + 1);
                visit[i] = false;
            }
        }
        
    }

    private static void calcDifference() {
        int startSum = 0;
        int linkSum = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    startSum += arr[i][j];
                    startSum += arr[j][i];
                } else if (!visit[i] && !visit[j]) {
                    linkSum += arr[i][j];
                    linkSum += arr[j][i];
                }
            }
        }
        min = Math.min(Math.abs(startSum - linkSum), min);
    }
}