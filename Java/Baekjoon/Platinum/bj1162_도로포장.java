package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1162_도로포장 {
    private static class Edge implements Comparable<Edge> {
        int end, count;
        long cost;

        Edge(int e, long c, int cnt) {
            this.end = e;
            this.cost = c;
            this.count = cnt;
        }

        public int compareTo(Edge e) {
            if (this.cost == e.cost) return this.count - e.count;
            return Long.compare(this.cost, e.cost);
        }
    }

    static int N, M, K;
    static long INF = Long.MAX_VALUE;
    static long[][] cost;
    static List<Edge>[] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cost = new long[N + 1][K + 1];
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
            Arrays.fill(cost[i], INF);
        }
        cost[1][0] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[s].add(new Edge(e, c, 0));
            edges[e].add(new Edge(s, c, 0));
        }
        dijkstra();

        long answer = INF;
        for (int i = 0; i <= K; i++)
            answer = Math.min(answer, cost[N][i]);

        System.out.println(answer);

    }

    private static void dijkstra() {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.cost != cost[cur.end][cur.count]) continue;

            for (Edge next : edges[cur.end]) {
                if (cur.count < K && cost[next.end][cur.count + 1] > cost[cur.end][cur.count]) {
                    cost[next.end][cur.count + 1] = cost[cur.end][cur.count];
                    pq.add(new Edge(next.end, cost[next.end][cur.count + 1], cur.count + 1));
                }

                if (cost[next.end][cur.count] > cost[cur.end][cur.count] + next.cost) {
                    cost[next.end][cur.count] = cost[cur.end][cur.count] + next.cost;
                    pq.add(new Edge(next.end, cost[next.end][cur.count], cur.count));
                }
            }
        }
    }
}
