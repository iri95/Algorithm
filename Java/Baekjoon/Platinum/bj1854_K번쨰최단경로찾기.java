package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1854_K번쨰최단경로찾기 {
    private static class Edge implements Comparable<Edge> {
        int index, cost;

        Edge(int i, int c) {
            this.index = i;
            this.cost = c;
        }

        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static int N, M, K;
    static List<Edge>[] edges;
    static Queue<Integer>[] distances;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        distances = new PriorityQueue[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
            distances[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[s].add(new Edge(e, c));
        }

        distances[1].add(0);
        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(distances[i].size() != K ? -1 : distances[i].poll()).append("\n");

        System.out.println(sb);
    }

    private static void dijkstra() {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            for (Edge next : edges[cur.index]) {
                if (distances[next.index].size() < K) {
                    distances[next.index].add(cur.cost + next.cost);
                    pq.add(new Edge(next.index, cur.cost + next.cost));
                } else if (distances[next.index].peek() > cur.cost + next.cost) {
                    distances[next.index].poll();
                    distances[next.index].add(cur.cost + next.cost);
                    pq.add(new Edge(next.index, cur.cost + next.cost));
                }
            }
        }
    }
}
