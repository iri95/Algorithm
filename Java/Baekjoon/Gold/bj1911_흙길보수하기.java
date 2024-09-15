package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1911_흙길보수하기 {
    private static class Water implements Comparable<Water> {
        int cnt, start, end;

        public int compareTo(Water w) {
            return this.start - w.start;
        }

        public Water(int start, int end) {
            this.cnt = end - start;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Queue<Water> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Water(s, e));
        }
        int end = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            Water w = pq.poll();
            if (end >= w.end) continue;
            if (end > w.start)  w.cnt -= (end - w.start);
            ans += w.cnt / L;
            if (w.cnt % L == 0) continue;
            ans++;
            end = w.end + (L - w.cnt % L);
        }
        System.out.println(ans);
    }
}
