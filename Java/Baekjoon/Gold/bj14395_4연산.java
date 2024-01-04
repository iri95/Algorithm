package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj14395_4연산 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long s = Long.parseLong(st.nextToken());
        Long t = Long.parseLong(st.nextToken());
        List<Long> list = new ArrayList<>();
        Queue<Long> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        queue1.offer(s);
        queue2.offer("");
        if (s.equals(t)) {
            System.out.println(0);
            return;
        }
        while (!queue1.isEmpty()) {
            int size = queue1.size();
            while (size-- > 0) {
                long value = queue1.poll();
                String operator = queue2.poll();
                if (list.contains(value) || value > 1000000000 || value <= 0) {
                    continue;
                }
                if (value == t) {
                    System.out.println(operator);
                    return;
                }
                list.add(value);

                long value3 = value * value;
                String op3 = operator + "*";
                queue1.offer(value3);
                queue2.offer(op3);

                long value1 = value * 2;
                String op1 = operator + "+";
                queue1.offer(value1);
                queue2.offer(op1);

                Long value4 = 1l;
                String op4 = operator + "/";
                queue1.offer(value4);
                queue2.offer(op4);
            }
        }
        System.out.println(-1);
    }
}
