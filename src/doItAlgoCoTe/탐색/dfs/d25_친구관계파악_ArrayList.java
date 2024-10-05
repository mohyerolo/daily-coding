package doItAlgoCoTe.탐색.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class d25_친구관계파악_ArrayList {
    private static int N;
    private static boolean[] visit;
    private static List<Integer>[] list;
    private static boolean status;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        int a,b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        find5Friends();
        System.out.println(0);
    }   

    private static void find5Friends() {
        for (int i = 0; i < N; i++) {
            visit[i] = true;
            dfs(i, 1);
            visit[i] = false;
        }
    }
    
    private static void dfs(int start, int depth) {
        if (depth == 5) {
            System.out.println(1);
            System.exit(0);
        }

        for (int num : list[start]) {
            if (!visit[num]) {
                visit[start] = true;
                dfs(num, depth + 1);
                visit[start] = false;
            }
        }
    }
}
