package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2211_네트워크복구 {
    private static class Edge implements Comparable<Edge> {
        int s, e, cost;

        Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
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
        for (int i = 0; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[s].add(new Edge(s, e, cost));
            edges[e].add(new Edge(e, s, cost));
        }

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        int answer = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.addAll(edges[1]);

        StringBuilder sb = new StringBuilder();
        sb.append(N - 1).append("\n");

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.e]) continue;
            visited[cur.e] = true;
            answer++;
            sb.append(cur.s).append(" ").append(cur.e).append("\n");

            if (answer == N - 1) break;

            for (Edge next : edges[cur.e]) {
                if (visited[next.e]) continue;
                pq.add(new Edge(cur.e, next.e, cur.cost + next.cost));
            }
        }

        System.out.println(sb);
    }


}
