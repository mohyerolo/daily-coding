package bfs.bfs_알고리즘중급_3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16946
public class 벽부수고이동하기_4 {
    private static class Zero {
        int row, col;
        Zero(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
        
    }

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    private static int N, M;
    private static byte[][] map;
    private static int[][] visit;
    private static Map<Integer, Integer> group = new HashMap<>();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new byte[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().getBytes();
        }

        int groupIndex = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0' && visit[i][j] == 0) {
                    bfs(i, j, groupIndex++);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '1') {
                    sb.append(calcResult(i, j));
                } else {
                    sb.append(0);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }    

    private static void bfs(final int row, final int col, final int groupIndex) {
        Queue<Zero> queue = new ArrayDeque<>();
        queue.offer(new Zero(row, col));
        visit[row][col] = groupIndex;

        int cnt = 0;
        while (!queue.isEmpty()) {
            Zero one = queue.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nextRow = one.row + dy[i];
                int nextCol = one.col + dx[i];

                if (checkRange(nextRow, nextCol) && visit[nextRow][nextCol] == 0 && map[nextRow][nextCol] == '0') {
                    visit[nextRow][nextCol] = groupIndex;
                    queue.offer(new Zero(nextRow, nextCol));
                }
            }
        }
        group.put(groupIndex, cnt);
    }

    private static boolean checkRange(final int row, final int col) {
        if (row < 0 || row >= N || col < 0 || col >= M) {
            return false;
        }
        return true;
    }

    private static int calcResult(final int row, final int col) {
        int cnt = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dy[i];
            int nextCol = col + dx[i];
            if (checkRange(nextRow, nextCol) && visit[nextRow][nextCol] != 0) {
                set.add(visit[nextRow][nextCol]);
            }
        }

        for (int num : set) {
            cnt += group.get(num);
        }

        return cnt % 10;
    }
}
