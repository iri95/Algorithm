package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1854_K번쨰최단경로찾기 {
    private static class Edge implements Comparable<Edge> {
        int node, cost;

        Edge(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        public int compareTo(Edge e) {
            return Integer.compare(this.cost, e.cost);
        }
    }

    static int N, M, K;
    static List<Edge>[] graph;
    static Queue<Integer>[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        dist = new PriorityQueue[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge(e, c));
        }

        dist[1].add(0);
        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(dist[i].size() != K ? -1 : dist[i].poll()).append("\n");

        System.out.println(sb);
    }

    private static void dijkstra() {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curNode = cur.node;
            int curCost = cur.cost;

            if (dist[curNode].size() == K && dist[curNode].peek() < curCost) continue;

            for (Edge next : graph[cur.node]) {
                int nextNode = next.node;
                int cost = curCost + next.cost;

                if (dist[nextNode].size() < K) {
                    dist[nextNode].add(cost);
                    pq.add(new Edge(next.node, cost));
                } else if (dist[nextNode].peek() > cost) {
                    dist[nextNode].poll();
                    dist[nextNode].add(cost);
                    pq.add(new Edge(nextNode, cost));
                }
            }
        }
    }
}
