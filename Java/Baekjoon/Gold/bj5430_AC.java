package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj5430_AC {
    static Deque<Integer> array = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] function = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for (int j = 0; j < N; j++) {
                array.add(Integer.parseInt(st.nextToken()));
            }
            AC(function);
        }
        System.out.println(sb);
    }

    static void AC(char[] function) {
        boolean back = false;
        for (char c : function) {
            if (c == 'D') {
                if (array.isEmpty()) {
                    sb.append("error").append("\n");
                    return;
                }
                if (back) array.removeLast();
                else array.remove();
            } else {
                back = !back;
            }
        }
        sb.append("[");
        if (!array.isEmpty()) {
            if (back) {
                sb.append(array.pollLast());
                while (!array.isEmpty()) {
                    sb.append(",").append(array.pollLast());
                }
            } else {
                sb.append(array.poll());
                while (!array.isEmpty()) {
                    sb.append(",").append(array.poll());
                }
            }
        }
        sb.append("]").append("\n");
    }
}