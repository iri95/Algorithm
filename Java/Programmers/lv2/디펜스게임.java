package lv2;

import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int M = enemy.length;
        int answer = Math.min(k, M);
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k && i < M; i++) {
            pq.add(enemy[i]);
        }
        for (int i = k; i < M; i++) {
            if (pq.peek() < enemy[i]) {
                n -= pq.poll();
                pq.add(enemy[i]);
            } else {
                n -= enemy[i];
            }
            if (n < 0) break;
            answer = i + 1;
        }
        return answer;
    }
}
