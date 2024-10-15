package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// https://www.acmicpc.net/problem/14226
public class c_이모티콘 {
    private static int S;
    private static Queue<int[]> queue = new ArrayDeque<>();
    private static boolean[][] visit;
    private static int cnt = 0;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visit = new boolean[1001][1001];
        bfs();
        System.out.println(cnt);
    }   
    
    private static void bfs() {
        queue.offer(new int[]{1, 0, 0});
        visit[1][0] = true;

        int[] result;
        int now, clipboard, sec;
        while (!queue.isEmpty()) {
            result = queue.poll();
            now = result[0];
            clipboard = result[1];
            sec = result[2];

            if (now == S) {
                cnt = sec;
                return;
            };

            copy(now, sec);
            paste(now, clipboard, sec);
            delete(now, clipboard, sec);
        }
    }

    private static void copy(int now, int sec) {
        if (now <= 0 || visit[now][now]) return;
        offerAndChangeTrue(now, now, sec);
    }

    private static void paste(int now, int clipboard, int sec) {
        int change = now + clipboard;
        if (clipboard <= 0 || change > 1000 || visit[change][clipboard]) return;
        offerAndChangeTrue(change, clipboard, sec);
    }

    private static void delete(int now, int clipboard, int sec) {
        int change = now - 1;
        if (change <= 0 || visit[change][clipboard]) return;
        offerAndChangeTrue(change, clipboard, sec);
    }

    private static void offerAndChangeTrue(int a, int b, int sec) {
        queue.offer(new int[]{a, b, sec + 1});
        visit[a][b] = true;
    }

}