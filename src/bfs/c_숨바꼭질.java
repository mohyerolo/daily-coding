package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1697
public class c_숨바꼭질 {
    private static int N, K;
    private static boolean[] visit;
    private static Queue<Section> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];

        System.out.println(bfs());
    }

    private static int bfs() {
        queue.offer(new Section(N, 0));

        while (!queue.isEmpty()) {
            Section section = queue.poll();
            int now = section.num;
            int nowCnt = section.cnt;

            if (now == K) return nowCnt;
            if (visit[now]) continue;

            visit[now] = true;
            tryMinusOne(now, nowCnt);
            tryPlusOne(now, nowCnt);
            tryMultiplyTwo(now, nowCnt);
        }

        return -1;
    }

    private static void tryMinusOne(int now, int nowCnt) {
        if (now - 1 < 0 || visit[now - 1]) return;
        queue.offer(new Section(now - 1, nowCnt + 1));
    }

    private static void tryPlusOne(int now, int nowCnt) {
        if (now + 1 > 100000 || visit[now + 1]) return;
        queue.offer(new Section(now + 1, nowCnt + 1));
    }

    private static void tryMultiplyTwo(int now, int nowCnt) {
        if (now * 2 > 100000 || visit[now * 2]) return;
        queue.offer(new Section(now * 2, nowCnt + 1));
    }

    private static class Section {
        int num, cnt;
        public Section(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
