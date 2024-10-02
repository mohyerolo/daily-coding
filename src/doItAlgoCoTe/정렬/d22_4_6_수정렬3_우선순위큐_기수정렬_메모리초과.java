package doItAlgoCoTe.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/10989
// 우선순위큐 이용 -> 메모리 초과 (Integer, LinkedList)
public class d22_4_6_수정렬3_우선순위큐_기수정렬_메모리초과 {
    private static int[] A;
    private static int N;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        radix_sort();

        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append('\n');
        }
        System.out.println(sb);

        usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");
    }

    @SuppressWarnings("unchecked")
    private static void radix_sort() {
        Queue<Integer>[] queue = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            queue[i] = new LinkedList<>();
        }

        int now = 0;
        int jarisu = 1;
        while (now++ < 5) {
            for (int i = 0; i < N; i++) {
                queue[(A[i] / jarisu) % 10].add(A[i]); // 자릿수의 마지막 값을 알아내는 것
            }

            for (int i = 0, AIndex = 0; i < 10; i++) {
                while (!queue[i].isEmpty()) {
                    A[AIndex++] = queue[i].poll();
                }
            }
            jarisu *= 10;
        }
    }
}
