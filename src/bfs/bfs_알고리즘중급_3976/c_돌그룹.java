package bfs.bfs_알고리즘중급_3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/12886
// 메모리: 36052	시간: 216  LinkedList로 변경 시 - 메모리; 48800   시간: 208
public class c_돌그룹 {
    private static class Rocks {
        int A, B, C;

        public Rocks(final int A, final int B, final int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }

        boolean allSame() {
            if (A == B && B == C) {
                return true;
            }
            return false;
        }
    }

    private static Queue<Rocks> queue = new ArrayDeque<>();
    private static boolean[][] visited = new boolean[1501][1501];

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        if ((A + B + C) % 3 != 0) {
           System.out.println(0);
           System.exit(0);
        }

        System.out.println(allSame(A, B, C));
    }

    private static int allSame(final int A, final int B, final int C) {
        queue.offer(new Rocks(A, B, C));
        visited[A][B] = true;

        while (!queue.isEmpty()) {
            Rocks rocks = queue.poll();
            if (rocks.allSame()) {
                return 1;
            }
            checkAB(rocks.A, rocks.B, rocks.C);
            checkBC(rocks.A, rocks.B, rocks.C);
            checkAC(rocks.A, rocks.B, rocks.C);
        }

        return 0;
    }

    private static void checkAB(final int A, final int B, final int C) {
        if (A != B) {
            int newA = A > B ? A - B : A + A;
            int newB = A > B ? B + B : B - A;
            
            if (!visited[newA][newB]) {
                queue.offer(new Rocks(newA, newB, C));
                visited[newA][newB] = true;
            }
        }
    }

    private static void checkBC(final int A, final int B, final int C) {
        if (B != C) {
            int newB = B > C ? B - C : B + B;
            int newC = B > C ? C + C : C - B;
            
            if (!visited[newB][newC]) {
                queue.offer(new Rocks(A, newB, newC));
                visited[newB][newC] = true;
            }
        }
    }

    private static void checkAC(final int A, final int B, final int C) {
        if (A != C) {
            int newA = A > C ? A - C : A + A;
            int newC = A > C ? C + C : C - A;
            
            if (!visited[newA][newC]) {
                queue.offer(new Rocks(newA, B, newC));
                visited[newA][newC] = true;
            }
        }
    }
}
