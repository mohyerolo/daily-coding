package doItAlgoCoTe.탐색.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class d25_친구관계파악_자체Node사용 {
    private static int N, M;
    private static Node[] node;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        node = new Node[N];
        visit = new boolean[N];

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            node[a] = new Node(b, node[a]);
            node[b] = new Node(a, node[b]);
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

    private static void dfs(int cur, int cnt) {
        if (cnt == 5) {
            System.out.println(1);
            System.exit(0);
        }

        for (Node now = node[cur]; now != null; now = now.frNode) {
            if (!visit[now.node]) {
                visit[now.node] = true;
                dfs(now.node, cnt + 1);
                visit[now.node] = false;
            }
        }
        
    }
}

class Node {
    int node;
    Node frNode;

    Node(int node, Node frNode) {
        this.node = node;
        this.frNode = frNode;
    }
}