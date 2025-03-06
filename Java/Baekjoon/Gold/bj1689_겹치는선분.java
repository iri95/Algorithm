package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1689_겹치는선분 {
    private static class Line implements Comparable<Line> {
        int s;
        int e;
        Line(int s, int e){
            this.s = s;
            this.e = e;
        }

        public int compareTo(Line l){
            return this.s - l.s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Line> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Line(s, e));
        }

        Collections.sort(list);
        Queue<Integer> pq = new PriorityQueue<>();
        int max = 0;

        for (int i = 0; i < N; i++) {
            Line l = list.get(i);
            while (!pq.isEmpty() && pq.peek() <= l.s) pq.poll();
            pq.add(l.e);
            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }
}
