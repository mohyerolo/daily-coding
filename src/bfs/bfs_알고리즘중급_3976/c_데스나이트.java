package bfs.bfs_알고리즘중급_3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16948
public class c_데스나이트 {
    private static int N;
    private static int[][] map;

    private static int[] dx = {-1, 1, -2, 2, -1, 1};
    private static int[] dy = {-2, -2, 0, 0, 2, 2};

    private static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = -1;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int[] start = new int[]{r1, c1};

        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int[] end = new int[]{r2, c2};

        System.out.println(bfs(start, end));
    }

    private static int bfs(int[] start, int[] end) {
        queue.offer(start);
        map[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];

            if (row == end[0] && col == end[1]) {
                return map[row][col];
            }
            playChess(row, col);
        }
        return -1;
    }

    private static void playChess(int row, int col) {
        for (int i = 0; i < 6; i++) {
            int nextRow = row + dy[i];
            int nextCol = col + dx[i];

            if (!checkRange(nextRow, nextCol)) {
                continue;
            }

            queue.offer(new int[]{nextRow, nextCol});
            map[nextRow][nextCol] = map[row][col] + 1;
        }
    }

    private static boolean checkRange(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N || map[row][col] != -1) {
            return false;
        }
        return true;
    }
}
