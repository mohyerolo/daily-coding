package doItAlgoCoTe.탐색.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2178
public class d27_미로탐색 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});

        visit[row][col] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = now[0] + dy[i];
                int nextCol = now[1] + dx[i];

                if (check(nextRow, nextCol)) {
                    queue.offer(new int[] {nextRow, nextCol});
                    map[nextRow][nextCol] = map[now[0]][now[1]] + 1;
                    visit[nextRow][nextCol] = true;
                }
            }
        }
    }

    private static boolean check(int nextRow, int nextCol) {
        if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) return false;
        if (visit[nextRow][nextCol] || map[nextRow][nextCol] == 0) return false;
        return true;
    }

}
