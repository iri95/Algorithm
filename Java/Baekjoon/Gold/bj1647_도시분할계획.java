package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1647_도시분할계획 {
    private static class Route implements Comparable<Route> {
        int s, e, c;

        public Route(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }

        public int compareTo(Route r) {
            return this.c - r.c;
        }
    }

    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) parents[i] = i;

        Queue<Route> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Route(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int sum = 0;
        int cnt = 0;
        while(cnt < N - 2) {
            Route r = pq.poll();
            int p1 = find(r.s);
            int p2 = find(r.e);
            if (p1 == p2) continue;
            union(p1, p2);
            sum += r.c;
            cnt++;
        }

        System.out.println(sum);

    }

    private static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int y, int x) {
        if (y < x) parents[x] = y;
        else parents[y] = x;
    }
}
