package bfs.bfs_알고리즘중급_3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class c_DSLR_class_eunm_사용 {
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visit;
    private static Queue<Register> queue;

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
        queue = new ArrayDeque<>();
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

            calc(num, command);
        }
    }

    private static void calc(int num, String command) {
        int d = DSLR.D.calc(num);
        int s = DSLR.S.calc(num);
        int l = DSLR.L.calc(num);
        int r = DSLR.R.calc(num);
        
        if (!visit[d]) {
            updateQueue(d, command, DSLR.D.getCommand());
        }
        if (!visit[s]) {
            updateQueue(s, command, DSLR.S.getCommand());
        }
        if (!visit[l]) {
            updateQueue(l, command, DSLR.L.getCommand());
        }
        if (!visit[r]) {
            updateQueue(r, command, DSLR.R.getCommand());
        }
    }

    private static void updateQueue(int num, String command, String addCommand) {
        queue.offer(new Register(num, command + addCommand));
        visit[num] = true;
    }
}

enum DSLR {
    D("D") {
        @Override
        public int calc(int num) {
            return (num * 2) % 10000;
        }
    },
    S("S") {
        @Override
        public int calc(int num) {
            return num == 0 ? 9999 : num - 1;
        }
    },
    L("L") {
        @Override
        public int calc(int num) {
            return (num % 1000) * 10 + num / 1000;
        }
    },
    R("R") {
        @Override
        public int calc(int num) {
            return (num % 10) * 1000 + num / 10;
        }
    };

    private String command;

    DSLR(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    public abstract int calc(int num);
}