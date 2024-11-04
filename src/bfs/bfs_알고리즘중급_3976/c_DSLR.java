package bfs.bfs_알고리즘중급_3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class c_DSLR {
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visit;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            visit = new boolean[10000];
            bfs(start, Integer.parseInt(end));
        }

        System.out.println(sb);
    }

    private static void bfs(String start, int end) {
        Queue<String[]> queue = new ArrayDeque<>();
        queue.offer(new String[]{start, ""});
        visit[Integer.parseInt(start)] = true;

        while(!queue.isEmpty()) {
            String[] register = queue.poll();
            int num = Integer.parseInt(register[0]);
            String command = register[1];

            if (num == end) {
                sb.append(command).append('\n');
                return;
            }

            DSLR(queue, num, command);
        }
    }

    private static void DSLR(Queue<String[]> queue, int num, String command) {
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

    private static void updateQueue(Queue<String[]> queue, int num, String command) {
        queue.offer(new String[]{String.valueOf(num), command});
        visit[num] = true;
    }
}
