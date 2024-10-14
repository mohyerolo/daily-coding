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
    private static Queue<Node> queue = new LinkedList<Node>();
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visit = new boolean[100001];
        System.out.println(bfs(new Node(N, 0)));
    }

    private static int bfs(Node node) {
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int num = now.num;
            int nowCnt = now.cnt;

            if (num == K) return nowCnt;
            if (visit[num]) continue;

            visit[num] = true;
            move(num - 1, nowCnt);
            move(num + 1, nowCnt);
            move(num * 2, nowCnt);
        }
        return -1;
    }

    private static void move(int num, int cnt) {
        if (num < 0 || num > 100000 || visit[num]) return;
        queue.offer(new Node(num, cnt + 1));
    }
}

class Node {
    int num, cnt;
    Node(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}