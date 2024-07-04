package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj13905_세부 {
    private static class Route implements Comparable<Route> {
        int a, b, c;

        public Route(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo(Route o) {
            return o.c - this.c;
        }
    }

    static int N, M, s, e;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        Queue<Route> pq = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Route(a, b, c));
            if (max < c) max = c;
        }
        while (!pq.isEmpty()) {
            Route r = pq.poll();
            int aP = find(r.a);
            int bP = find(r.b);
            if (aP != bP) {
                set(aP, bP);
                max = Math.min(max, r.c);
                // https://www.acmicpc.net/source/74336803
                if (find(s) == find(e)) {
                    System.out.println(max);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static int find(int x){
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    private static void set(int x, int y){
        if (x > y) parent[x] = y;
        else parent[y] = x;
    }
}
