package lv2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 혼자놀기의달인 {
    public int solution(int[] cards) {
        int answer = 1;
        int M = cards.length;
        boolean[] visit = new boolean[M];
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < M; i++){
            if(visit[i]) continue;
            int k = i;
            int count = 0;
            while(!visit[k]){
                visit[k] = true;
                count++;
                k = cards[k] - 1;
            }
            pq.add(count);
        }
        int size = pq.size();
        if(size == 1) return 0;
        for(int i = 0; i < 2; i++){
            answer *= pq.poll();
        }
        return answer;
    }
}
