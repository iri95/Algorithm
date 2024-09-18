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
                stack.pop();
                ans += mul;
                mul /= 2;
                while (i < arr.length - 1) {
                    if (stack.isEmpty()) break;
                    char c = stack.peek();
                    if (c == ')' || c == ']' || arr[i + 1] == '(' || arr[i + 1] == '[') break;
                    if (arr[i + 1] == ')' && c == '(') {
                        stack.pop();
                        mul /= 2;
                    } else if (arr[i + 1] == ']' && c == '[') {
                        stack.pop();
                        mul /= 3;
                    }
                    i++;
                }
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                ans += mul;
                mul /= 3;
                while (i < arr.length - 1) {
                    if (stack.isEmpty()) break;
                    char c = stack.peek();
                    if (c == ')' || c == ']' || arr[i + 1] == '(' || arr[i + 1] == '[') break;
                    if (arr[i + 1] == ')' && c == '(') {
                        stack.pop();
                        mul /= 2;
                    } else if (arr[i + 1] == ']' && c == '[') {
                        stack.pop();
                        mul /= 3;
                    }
                    i++;
                }
            }
        }
        if (!stack.isEmpty()) System.out.println(0);
        else System.out.println(ans);
    }
}
