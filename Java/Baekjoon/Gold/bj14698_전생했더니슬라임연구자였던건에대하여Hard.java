package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14698_전생했더니슬라임연구자였던건에대하여Hard {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long INF = 1_000_000_007;
        Queue<Long> pq = new PriorityQueue<>();
        for (int t = 0; t < T; t++) {
            pq.clear();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) pq.add(Long.parseLong(st.nextToken()));
            long ans = 1;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                long mul = a * b;
                ans = (ans * (mul % INF)) % INF;
                pq.add(mul);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}