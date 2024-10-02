package doItAlgoCoTe.탐색.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11724
// ArrayList를 이용한 풀이
public class d23_5_1_연결요소개수_dfs_ArrayList {
    private static ArrayList<Integer>[] A;
    private static boolean[] visit;
    private static int cnt = 0;
    private static int N;

    @SuppressWarnings("unchecked")
    // ArrayList<Integer>가 new ArrayList[N + 1]로 생성되면서 type safe 보장이 안됨
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        
        findConnectedComponent();
        
        System.out.println(cnt);
    }

    private static void findConnectedComponent() {
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                cnt++;
                dfs(i);
            }
        }
    }

    private static void dfs(int v) {
        if (visit[v]) return;
        visit[v] = true;
        for (int i : A[v]) {
            if (!visit[i]) dfs(i);
        }
    }
}
