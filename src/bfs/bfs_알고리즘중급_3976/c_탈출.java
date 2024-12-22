package bfs.bfs_알고리즘중급_3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3055
public class c_탈출 {
    private static class Node {
        int row, col, cnt;
        Node(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
        
    }

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static int R, C;
    private static char[][] map;
    private static Queue<Node> queue = new ArrayDeque<>();
    private static Queue<Node> waterQueue = new ArrayDeque<>();

    // 비어있음:. 물:* 돌:X 비버:D 고슴도치:S
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    queue.offer(new Node(i, j, 0));
                } else if (map[i][j] == '*') {
                    waterQueue.add(new Node(i, j, 0));
                }
            }
        }

        System.out.println(bfs());
    }

    private static String bfs() {
        while (!queue.isEmpty()) {
            waterQueueMove();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                int result = SMoveAllDirection(node);
                if (result > 0) {
                    return String.valueOf(result);
                }
            }
        }
        return "KAKTUS";
    }

    private static void waterQueueMove() {
        int size = waterQueue.size();
        for (int i = 0; i < size; i++) {
            waterMoveAllDirection(waterQueue.poll());
        }
    }

    private static void waterMoveAllDirection(final Node water) {
        for (int i = 0; i < 4; i++) {
            int nextRow = water.row + dy[i];
            int nextCol = water.col + dx[i];
            if (checkRange(nextRow, nextCol) && map[nextRow][nextCol] == '.') {
                map[nextRow][nextCol] = '*';
                waterQueue.offer(new Node(nextRow, nextCol, 0));
            }
        }
    }

    private static int SMoveAllDirection(final Node node) {
        for (int i = 0; i < 4; i++) {
            int nextRow = node.row + dy[i];
            int nextCol = node.col + dx[i];
            if (checkRange(nextRow, nextCol) && map[nextRow][nextCol] != '*') {
                if (map[nextRow][nextCol] == 'D') {
                    return node.cnt + 1;
                }
                if (map[nextRow][nextCol] == '.') {
                    map[nextRow][nextCol] = 'S';
                    queue.offer(new Node(nextRow, nextCol, node.cnt + 1));
                };
            }
        }
        return -1;
    }

    private static boolean checkRange(final int row, final int col) {
        if (row < 0 || row >= R || col < 0 || col >= C || map[row][col] == 'X') {
            return false;
        }
        return true;
    }
}
