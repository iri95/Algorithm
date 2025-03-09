package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj10423_전기가부족해 {
    private static class Cable implements Comparable<Cable> {
        int s, e, cost;

        Cable(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.cost = c;
        }

        public int compareTo(Cable c) {
            return this.cost - c.cost;
        }
    }

    static int[] parent;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) set.add(Integer.parseInt(st.nextToken()));

        Queue<Cable> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Cable(s, e, c));
        }

        int answer = 0;
        int cnt = 0;
        while (cnt < N - K) {
            Cable c = pq.poll();
            if (union(c.s, c.e)) {
                answer += c.cost;
                cnt++;
            }
        }

        System.out.println(answer);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int x, int y) {
        int xp = find(x);
        int yp = find(y);

        if ((set.contains(xp) && set.contains(yp)) || (yp == xp)) return false;

        if (set.contains(xp)) parent[yp] = xp;
        else if (set.contains(yp)) parent[xp] = yp;
        else if (xp > yp) parent[xp] = yp;
        else parent[yp] = xp;

        return true;
    }
}
