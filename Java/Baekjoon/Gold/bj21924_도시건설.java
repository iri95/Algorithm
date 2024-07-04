package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj21924_도시건설 {
    private static class Route implements Comparable<Route> {
        int a, b, c;

        public Route(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo(Route o) {
            return this.c - o.c;
        }
    }
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        Queue<Route> pq = new PriorityQueue<>();
        long ans = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Route(a, b, c));
            ans += c;
        }
        while (!pq.isEmpty()) {
            Route r = pq.poll();
            int aP = find(r.a);
            int bP = find(r.b);
            if (aP != bP) {
                ans -= r.c;
                set(aP, bP);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (find(i) != 1) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ans);
    }
    static int find(int x){
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void set(int x, int y){
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
}
