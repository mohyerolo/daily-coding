package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13913
// 노드 클래스 없이 배열만 사용해봄
public class c_숨바꼭질4_배열만사용 {
    private static int N, K;
    private static int[] parentArr;
    private static int[] visitCnt;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parentArr = new int[100001];
        visitCnt = new int[100001];

        bfs();
        int cnt = visitCnt[K];

        // 경로 길이 알고있으니까 스택보다 배열 쓰는 게 메모리 더 효율적
        int[] path = new int[cnt + 1];
        int idx = cnt;
        int parent = K;
        while (parent != N) {
            path[idx--] = parent;
            parent = parentArr[parent];
        }
        path[idx] = N;

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n');
        for (int i = 0; i < path.length; i++) {
            sb.append(path[i]).append(' ');
        }

        System.out.println(sb);
    }

    private static void bfs() {
        queue.offer(N);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num == K) return;

            move(num - 1, num);
            move(num + 1, num);
            move(num * 2, num);
        }
    }

    private static void move(int num, int now) {
        if (num < 0 || num > 100000 || visitCnt[num] != 0) return;
        visitCnt[num] = visitCnt[now] + 1;
        queue.offer(num);
        parentArr[num] = now;
    }
}
