package doItAlgoCoTe.탐색.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1167
public class d28_트리의지름 {
    private static int V;
    private static ArrayList<Node>[] tree;
    private static boolean[] visit;
    private static int[] sum;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        visit = new boolean[V + 1];
        sum = new int[V + 1];

        tree = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            tree[i] = new ArrayList<Node>();
        }

        StringTokenizer st;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int edge;
            while ((edge = Integer.parseInt(st.nextToken())) != -1) {
                tree[now].add(new Node(edge, Integer.parseInt(st.nextToken())));
            }
        }

        bfs(1);
        int max = 1;
        for (int i = 1; i < V + 1; i++) {
            if (sum[max] < sum[i]) max = i;
        }

        visit = new boolean[V + 1];
        sum = new int[V + 1];
        bfs(max);
        int result = sum[1];
        for (int i = 2; i < V + 1; i++) {
            if (result < sum[i]) result = sum[i];
        }

        System.out.println(result);
    }   
    
    private static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visit[index] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Node node : tree[now]) {
                int num = node.num;
                int weight = node.distance;
                if (!visit[num]) {
                    visit[num] = true;
                    queue.offer(num);
                    sum[num] = sum[now] + weight;
                }
            }
        }
    }
}

class Node {
    int num;
    int distance;
    
    public Node(int num, int distance) {
        this.num = num;
        this.distance = distance;
    }
}
