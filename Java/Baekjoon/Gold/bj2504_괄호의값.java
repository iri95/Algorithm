package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj2504_괄호의값 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int ans = 0;
        int mul = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push('(');
                mul *= 2;
            } else if (arr[i] == '[') {
                stack.push('[');
                mul *= 3;
            } else if (arr[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                if (arr[i - 1] == '(') ans += mul;
                stack.pop();
                mul /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if (arr[i - 1] == '[') ans += mul;
                stack.pop();
                mul /= 3;
            }
        }
        if (!stack.isEmpty()) System.out.println(0);
        else System.out.println(ans);
    }
}
