package doItAlgoCoTe.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class d11_3_5_스택으로오름차순 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int now = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > now) {
                for (int j = now + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                now = num;
            } else if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
