package lv3;

import java.util.*;

public class 야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < works.length; i++) pq.add(works[i]);
        while (n > 0) {
            int a = pq.poll() - 1;
            n--;
            if (a == 0) {
                if (pq.isEmpty()) return 0;
                continue;
            } else pq.add(a);
        }
        while (!pq.isEmpty()) {
            int a = pq.poll();
            answer += (long) a * a;
        }
        return answer;
    }
}
