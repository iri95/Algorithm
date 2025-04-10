package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj14284_간선이어가기2 {
    private static class Edge implements Comparable<Edge> {
        int node, cost;

        Edge(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[s].add(new Edge(e, c));
            edges[e].add(new Edge(s, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[s] = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s, 0));

        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.node == t) break;
            if (visited[cur.node]) continue;
            visited[cur.node] = true;

            for (Edge next : edges[cur.node]) {
                if (dist[cur.node] + next.cost < dist[next.node]) {
                    dist[next.node] = dist[cur.node] + next.cost;
                    pq.add(new Edge(next.node, dist[next.node]));
                }
            }
        }
        System.out.println(dist[t]);
    }
}
