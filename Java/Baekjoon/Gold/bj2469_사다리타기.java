package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj2469_사다리타기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        char[] list = new char[k];
        for (int i = 0; i < k; i++) {
            list[i] = (char) ('A' + i);
        }
        char[] ans = br.readLine().toCharArray();
        boolean flag = false;
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            if (a.charAt(0) == '?') flag = true;
            if (flag) {
                stack.push(a);
                continue;
            }
            for (int j = 0; j < k - 1; j++) {
                if (a.charAt(j) == '-')
                    swap(list, j);
            }
        }
        while (!stack.isEmpty()) {
            String a = stack.pop();
            for (int i = 0; i < k - 1; i++)
                if (a.charAt(i) == '-')
                    swap(ans, i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            if (list[i] == ans[i]) sb.append('*');
            else if (list[i] == ans[i + 1] && list[i + 1] == ans[i]) {
                sb.append('-');
                swap(list, i);
            } else {
                sb = new StringBuilder();
                sb.append("x".repeat(k - 1));
                break;
            }
        }
        System.out.println(sb);
    }

    private static void swap(char[] list, int x) {
        char b = list[x];
        list[x] = list[x + 1];
        list[x + 1] = b;
    }
}
