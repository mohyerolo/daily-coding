package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13913
// 전의 코드와 이어지게 노드 사용해봄
public class c_숨바꼭질4 {
    private static int N, K;
    private static Queue<Node> queue = new LinkedList<Node>();
    private static int[] parentArr;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parentArr = new int[100001];
        visit = new boolean[100001];

        int cnt = bfs();
        
        // Stack<Integer> stack = new Stack<>();
        // int parent = K;
        // while (parent != N) {
        //     stack.push(parent);
        //     parent = parentArr[parent];
        // }
        // stack.push(parent);

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
        // while (!stack.empty()) {
        //     sb.append(stack.pop()).append(' ');
        // }
        for (int i = 0; i < path.length; i++) {
            sb.append(path[i]).append(' ');
        }

        System.out.println(sb);
    }

    private static int bfs() {
        queue.offer(new Node(N, 0));
        visit[N] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int num = now.num;
            int cnt = now.cnt;

            if (num == K) return cnt;

            move(num - 1, cnt, num);
            move(num + 1, cnt, num);
            move(num * 2, cnt, num);
        }
        return -1;
    }

    private static void move(int num, int cnt, int now) {
        if (num < 0 || num > 100000 || visit[num]) return;
        visit[num] = true;
        queue.offer(new Node(num, cnt + 1));
        parentArr[num] = now;
    }
}

class Node {
    int num, cnt;
    Node(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}
