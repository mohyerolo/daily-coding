package bfs.bfs_알고리즘중급_3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16928
public class c_뱀과사다리게임 {
    private static int[] map;
    private static int[] cnt;
    private static boolean[] visit;
    private static Queue<Integer> queue = new ArrayDeque<Integer>();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[101];
        cnt = new int[101];
        visit = new boolean[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bfs();
    }    

    private static void bfs() {
        queue.offer(1);
        visit[1] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if (now == 100) {
                System.out.println(cnt[now]);
                return;
            }
            rollDice(now);
        }
    }

    private static void rollDice(int now) {
        for (int i = 1; i < 7; i++) {
            int next = now + i;
            if (next > 100 || visit[next]) {
                continue;
            }
            visit[next] = true;

            if (map[next] != 0) {
                snakeOrLadder(now, map[next]);
            } else {
                queue.offer(next);
                cnt[next] = cnt[now] + 1;
            }
        }
    }

    private static void snakeOrLadder(int now, int snakeOrLadderResult) {
        if (!visit[snakeOrLadderResult]) {
            queue.offer(snakeOrLadderResult);
            visit[snakeOrLadderResult] = true;
            cnt[snakeOrLadderResult] = cnt[now] + 1;
        }
    }
}
