package lv3;

import java.util.*;

public class 상담원인원 {
    static class Person {
        int start;
        int time;

        public Person(int s, int t) {
            this.start = s;
            this.time = t;
        }
    }

    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        List<Person>[] list = new ArrayList[k + 1];
        for (int i = 0; i <= k; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] p : reqs) {
            list[p[2]].add(new Person(p[0], p[1]));
        }
        int maxMento = n - k + 1;
        int[][] times = new int[k + 1][maxMento + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= maxMento; j++) {
                Queue<Integer> pq = new PriorityQueue<>();
                for (int q = 0; q < j; q++) pq.add(0);
                for (Person p : list[i]) {
                    int end = pq.poll();
                    if (end <= p.start) end = p.start + p.time;
                    else {
                        times[i][j] += end - p.start;
                        end += p.time;
                    }
                    pq.add(end);
                }
            }
        }
        for (int i = 1; i <= k; i++) answer += times[i][1];
        int[] count = new int[k + 1];
        Arrays.fill(count, 1);
        for (int i = 1; i < maxMento; i++) {
            int max = 0;
            int plus = 0;
            for (int j = 1; j <= k; j++) {
                int now = count[j];
                int next = count[j] + 1;
                if (times[j][now] == times[j][next]) continue;
                if (max < times[j][now] - times[j][next]) {
                    max = times[j][now] - times[j][next];
                    plus = j;
                }
            }
            count[plus]++;
            answer -= max;
        }
        return answer;
    }
}