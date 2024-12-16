package bfs.bfs_알고리즘중급_3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class c_벽부수고이동하기 {
    private static class Space {
        int row, col;
        int moveCnt;
        int broken;

        public Space(final int row, final int col, final int moveCnt, final int broken) {
            this.row = row;
            this.col = col;
            this.moveCnt = moveCnt;
            this.broken = broken;
        }
    }

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static byte[][] map;
    private static int[][] visit;
    private static Queue<Space> queue = new ArrayDeque<>();
    private static int N, M;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new byte[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().getBytes();
            for (int j = 0; j < M; j++) {
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        queue.offer(new Space(0, 0, 1, 0));
        visit[0][0] = 0;

        while (!queue.isEmpty()) {
            Space space = queue.poll();
            if (space.row == N - 1 && space.col == M - 1) {
                return space.moveCnt;
            }

            moveAllDirection(space);
        }
        return -1;
    }

    private static void moveAllDirection(final Space space) {
        int row = space.row;
        int col = space.col;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dy[i];
            int nextCol = col + dx[i];
            if (checkRange(nextRow, nextCol, space.broken)) {
                moveToNext(nextRow, nextCol, space);
            }
        }
    }

    private static void moveToNext(final int row, final int col, final Space space) {
        if (map[row][col] == '0') {
            moveToNoWall(row, col, space);
            return;
        }
        moveIfNeverBrokenBefore(row, col, space);
    }

    private static void moveToNoWall(final int row, final int col, final Space space) {
        visit[row][col] = space.broken;
        queue.offer(new Space(row, col, space.moveCnt + 1, space.broken));
    }

    private static void moveIfNeverBrokenBefore(final int row, final int col, final Space space) {
        if (space.broken == 0) {
            visit[row][col] = space.broken + 1;
            queue.offer(new Space(row, col, space.moveCnt + 1, space.broken + 1));
        }
    }
 
    private static boolean checkRange(final int row, final int col, final int broken) {
        if (row < 0 || row >= N || col < 0 || col >= M || visit[row][col] <= broken) {
            return false;
        }
        return true;
    }
}
