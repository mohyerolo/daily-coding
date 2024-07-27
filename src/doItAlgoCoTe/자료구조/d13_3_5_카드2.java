package doItAlgoCoTe.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// https://www.acmicpc.net/problem/2164
public class d13_3_5_카드2 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // ArrayDeque: 28908KB	192ms
        // LinkedList: 45472KB	188ms
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while (queue.size() != 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
