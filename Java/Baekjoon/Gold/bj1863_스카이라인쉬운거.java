package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj1863_스카이라인쉬운거 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                if (y != 0) stack.push(y);
                continue;
            }
            if (stack.peek() < y)
                stack.push(y);
            else if (stack.peek() > y) {
                while (!stack.isEmpty() && stack.peek() > y) {
                    stack.pop();
                    count++;
                }
                if (y == 0) continue;
                if (!stack.isEmpty() && stack.peek() == y) continue;
                stack.push(y);
            }
        }
        count += stack.size();
        System.out.println(count);
    }
}
