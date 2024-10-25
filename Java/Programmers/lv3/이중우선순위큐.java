package lv3;

import java.util.*;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        Queue<Integer> ascPq = new PriorityQueue<>();
        Queue<Integer> descPq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            char c = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            if (c == 'I') {
                descPq.add(num);
                ascPq.add(num);
            } else {
                if (num == 1 && !descPq.isEmpty()) {
                    int a = descPq.poll();
                    ascPq.remove(a);
                } else if (num == -1 && !ascPq.isEmpty()) {
                    int a = ascPq.poll();
                    descPq.remove(a);
                }
            }
        }
        return descPq.isEmpty() ? new int[]{0, 0} : new int[]{descPq.poll(), ascPq.poll()};
    }
}