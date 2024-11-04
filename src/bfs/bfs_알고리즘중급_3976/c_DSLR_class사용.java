package bfs.bfs_알고리즘중급_3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9019
// 메모리: 305668KB, 시간 3436ms -> 제일 적은 메모리, 시간

public class c_DSLR_class사용 {
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visit;

    private static class Register {
        int num;
        String command;

        public Register(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            visit = new boolean[10000];
            bfs(start, end);
        }

        System.out.println(sb);
    }

    private static void bfs(int start, int end) {
        Queue<Register> queue = new ArrayDeque<>();
        queue.offer(new Register(start, ""));
        visit[start] = true;

        while(!queue.isEmpty()) {
            Register register = queue.poll();
            int num = register.num;
            String command = register.command;

            if (num == end) {
                sb.append(command).append('\n');
                return;
            }

            DSLR(queue, num, command);
        }
    }

    private static void DSLR(Queue<Register> queue, int num, String command) {
        int d = D(num);
        int s = S(num);
        int l = L(num);
        int r = R(num);
        
        if (!visit[d]) {
            updateQueue(queue, d, command + "D");
        }
        if (!visit[s]) {
            updateQueue(queue, s, command + "S");
        }
        if (!visit[l]) {
            updateQueue(queue, l, command + "L");
        }
        if (!visit[r]) {
            updateQueue(queue, r, command + "R");
        }
    }

    private static int D(int num) {
        return (num * 2) % 10000;
    }

    private static int S(int num) {
        return num == 0 ? 9999 : num - 1;
    }

    private static int L(int num) {
        return (num % 1000) * 10 + num / 1000;
    }

    private static int R(int num) {
        return (num % 10) * 1000 + num / 10;
    }

    private static void updateQueue(Queue<Register> queue, int num, String command) {
        queue.offer(new Register(num, command));
        visit[num] = true;
    }
}
