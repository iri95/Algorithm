package lv3;
import java.util.*;

public class 디스크컨트롤러 {
    private static class Work implements Comparable<Work>{
        int no, request, time;
        Work(int n, int r, int t){
            this.no = n;
            this.request = r;
            this.time = t;
        }

        public int compareTo(Work w){
            if(this.time == w.time){
                if(this.request == w.request) return this.no - w.no;
                return this.request - w.request;
            }
            return this.time - w.time;
        }
    }
    public int solution(int[][] jobs) {
        int N = jobs.length;

        Work[] works = new Work[N];
        for(int i = 0; i < N; i++)
            works[i] = new Work(i, jobs[i][0], jobs[i][1]);

        Arrays.sort(works, (w1, w2) -> {
            if(w1.request == w2.request) {
                if(w1.time == w2.time) return w1.no - w2.no;
                return w1.time - w2.time;
            }
            return w1.request - w2.request;
        });

        Queue<Work> pq = new PriorityQueue<>();
        int time = 0;
        int index = 0;
        int count = 0;
        int answer = 0;

        while(count++ < N){
            while(index < N){
                if(works[index].request <= time) {
                    pq.add(works[index]);
                    index++;
                } else break;
            }

            if(pq.isEmpty()){
                time = works[index].request;
                pq.add(works[index]);
                index++;
            }

            Work cur = pq.poll();
            time += cur.time;
            answer += time - cur.request;
        }

        return answer / N;
    }
}
