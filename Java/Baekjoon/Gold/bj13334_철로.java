package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj13334_철로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
        PriorityQueue<Integer> pqx = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (b >= a) pq.add(new int[]{a, b});
            else pq.add(new int[]{b, a});
        }

        int d = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            pqx.add(p[0]);
            while (!pqx.isEmpty() && pqx.peek() < p[1] - d) pqx.poll();
            cnt = Math.max(cnt, pqx.size());
        }

        System.out.println(cnt);

    }
}
