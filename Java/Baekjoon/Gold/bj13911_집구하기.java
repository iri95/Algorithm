package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj13911_집구하기 {
    private static class Edge implements Comparable<Edge> {
        int next, cost;

        Edge(int n, int c) {
            this.next = n;
            this.cost = c;
        }

        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static int V;
    static boolean[] house;
    static long[] mac;
    static long[] star;
    static List<Edge>[] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        house = new boolean[V + 1];
        Arrays.fill(house, true);

        edges = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[s].add(new Edge(e, c));
            edges[e].add(new Edge(s, c));
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        mac = new long[V + 1];
        Arrays.fill(mac, x + 1);

        st = new StringTokenizer(br.readLine());
        int[] macNum = new int[M];
        for (int i = 0; i < M; i++) {
            int s = Integer.parseInt(st.nextToken());
            house[s] = false;
            macNum[i] = s;
        }
        dijkstra(mac, macNum, x);

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        star = new long[V + 1];
        Arrays.fill(star, y + 1);

        st = new StringTokenizer(br.readLine());
        int[] starNum = new int[S];
        for (int i = 0; i < S; i++) {
            int s = Integer.parseInt(st.nextToken());
            house[s] = false;
            starNum[i] = s;
        }
        dijkstra(star, starNum, y);

        long result = Long.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            if (!house[i] || mac[i] == x + 1 || star[i] == y + 1) continue;
            result = Math.min(mac[i] + star[i], result);
        }

        if (result == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    private static void dijkstra(long[] costs, int[] start, int max) {
        boolean[] visited = new boolean[V + 1];
        Queue<Edge> pq = new PriorityQueue<>();

        for (int j : start)
            pq.add(new Edge(j, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.next]) continue;
            visited[cur.next] = true;

            for (Edge next : edges[cur.next]) {
                int cost = next.cost + cur.cost;
                if (visited[next.next] || costs[next.next] <= cost) continue;
                costs[next.next] = cost;
                pq.add(new Edge(next.next, cost));
            }
        }
    }
}