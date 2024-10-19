package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class c_알고스팟 {
    private static class Wall implements Comparable<Wall>{
        int row, col, brokenCnt;
        Wall(int row, int col, int brokenCnt) {
            this.row = row;
            this.col = col;
            this.brokenCnt = brokenCnt;
        }
        @Override
        public int compareTo(Wall o) {
            return brokenCnt - o.brokenCnt;
        }
    }

    private static int N, M;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static boolean[][] visit;
    private static byte[][] map;
    private static int result;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new byte[N][M];
        visit = new boolean[N][M];

        if (N == 1 && M == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().getBytes();
        }

        bfs();
        System.out.println(result);
    }   

    private static void bfs() {
        Queue<Wall> queue = new PriorityQueue<Wall>();
        queue.offer(new Wall(0, 0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Wall wall = queue.poll();

            if (wall.row == N - 1 && wall.col == M - 1) {
                result = wall.brokenCnt;
                return;
            }
            
            checkUpDownLeftRight(queue, wall);   
        }
    }

    private static void checkUpDownLeftRight(Queue<Wall> queue, Wall wall) {
        for (int i = 0; i < 4; i++) {
            int nextRow = wall.row + dy[i];
            int nextCol = wall.col + dx[i];

            if (isValidRange(nextRow, nextCol)) {
                visit[nextRow][nextCol] = true;
                addPath(queue, nextRow, nextCol, wall.brokenCnt);
            }
        }
    }

    private static boolean isValidRange(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M && !visit[row][col];
    }

    private static void addPath(Queue<Wall> queue, int nextRow, int nextCol, int beforeCnt) {
        int walls = map[nextRow][nextCol] - 48 == 0 ? beforeCnt : beforeCnt + 1;
        queue.offer(new Wall(nextRow, nextCol, walls));
    }
}
