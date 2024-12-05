package bfs.bfs_알고리즘중급_3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14502
// 메모리: 305084	시간: 1068
public class c_연구소 {
    private static final int WALL_MAX_CNT = 3;
    private static final int VIRUS = 2;
    private static final int WALL = 1;
    private static final int SAFE = 0;

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    
    private static int N, M;
    private static int[][] map;
    private static int[][] copy;
    private static int max;

    private static class Virus {
        private final int row, col;
        public Virus(final int row, final int col) {
            this.row = row;
            this.col = col;
        }

        int getNextRow(final int now) {
            return row + now;
        }

        int getNextCol(final int now) {
            return col + now;
        }
    }

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        createWall(0);
        System.out.println(max);
    }

    private static void createWall(final int cnt) {
        if (cnt == WALL_MAX_CNT) {
            spreadsVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == SAFE) {
                    map[i][j] = WALL;
                    createWall(cnt + 1);
                    map[i][j] = SAFE;
                }
            }
        }
    }

    private static void spreadsVirus() {
        Queue<Virus> queue = new ArrayDeque<>();
        addVirusQueue(queue);
        
        copy = copyMap();
        while (!queue.isEmpty()) {
            Virus virus = queue.poll();
            checkAround(queue, virus);
        }
        
        findSafeZone();
    }

    private static void addVirusQueue(final Queue<Virus> queue) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == VIRUS) {
                    queue.offer(new Virus(i, j));
                }
            }
        }
    }

    private static int[][] copyMap() {
        return Arrays.stream(map)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    private static void checkAround(final Queue<Virus> queue, final Virus virus) {
        for (int i = 0; i < 4; i++) {
            int nextRow = virus.getNextRow(dy[i]);
            int nextCol = virus.getNextCol(dx[i]);

            if (checkRange(nextRow, nextCol)) {
                queue.add(new Virus(nextRow, nextCol));
                copy[nextRow][nextCol] = VIRUS;
            }
        }
    }

    private static boolean checkRange(final int row, final int col) {
        if (row < 0 || row >= N || col < 0 || col >= M || copy[row][col] != 0) return false;
        return true;
    }

    private static void findSafeZone() {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == SAFE) safe++;
            }
        }

        if (max < safe) {
            max = safe;
        }
    }
    
}
