package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class c_숨바꼭질3 {
    private static int N, K;
    private static int[] visit;
    private static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new int[100001];
        for (int i = 0; i < visit.length; i++) {
            visit[i] = -1;
        }
        bfs();
        System.out.println(visit[K]);
    }    

    private static void bfs() {
        queue.offer(N);
        visit[N] = 0;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num == K) return;

            move(num * 2, visit[num]);
            move(num - 1, visit[num] + 1);
            move(num + 1, visit[num] + 1);
        }
    }

    private static void move(int change, int sec) {
        if (change < 0 || change > 100000 || visit[change] != -1) return;
        queue.offer(change);
        visit[change] = sec;
    }
}
