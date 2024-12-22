package bfs.bfs_알고리즘중급_3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class c_움직이는미로탈출 {
    private static class Node {
        int row, col;
        Node(final int row, final int col) {
            this.row = row;
            this.col = col;
        }        
    }
    
    private static int[] dx = {0, 0, -1, 1, 0, -1, 1, -1, 1};
    private static int[] dy = {-1, 1, 0, 0, 0, -1, -1, 1, 1};
    private static boolean[][] board = new boolean[8][8];
    private static boolean[][] visit;
    private static int cnt = 0;
    private static Queue<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (str.charAt(j) == '#') {
                    board[i][j] = true;
                    cnt++;
                }
            }
        }

        if (cnt == 0) {
            System.out.println(1);
        }
        else {
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        queue.offer(new Node(7, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            visit = new boolean[8][8];

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.row == 0 && node.col == 7) return 1;
                if (cnt == 0) return 1;
                if (board[node.row][node.col]) continue;

                moveAllDistance(node);
            }
            move();
        }
        return 0;
    }

    private static void moveAllDistance(final Node node) {
        for (int j = 0; j < 9; j++) {
            int nextRow = node.row + dy[j];
            int nextCol = node.col + dx[j];

            if (checkRange(nextRow, nextCol)) {
                queue.offer(new Node(nextRow, nextCol));
                visit[nextRow][nextCol] = true;
            }
        }
    }

    private static boolean checkRange(final int row, final int col) {
        if (row < 0 || row >= 8 || col < 0 || col >= 8 || visit[row][col] || board[row][col]) {
            return false;
        }
        return true;
    }

    private static void move() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j]) {
                    downWall(i, j);
                }
            }
        }
    }

    private static void downWall(final int row, final int col) {
        board[row][col] = false;
        if (row != 7) {
            board[row + 1][col] = true;
        } else {
            cnt--;
        }
    }
}