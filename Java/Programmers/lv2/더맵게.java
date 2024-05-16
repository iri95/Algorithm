package lv2;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Long> pq = new PriorityQueue<>();
        int N = scoville.length;
        for (int j : scoville) {
            pq.add((long) j);
        }
        while (pq.size() > 1 && pq.peek() < K) {
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a + b * 2);
            answer++;
        }
        if (pq.size() == 2 && pq.peek() < K) answer = -1;

        return answer;
    }
}
