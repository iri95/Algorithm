package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj9370_미확인도착지 {
    static class Edge implements Comparable<Edge> {
        int next;
        int cost;

        public Edge(int n, int c) {
            this.next = n;
            this.cost = c;
        }

        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int T, n, m, t, s, g, h, INF = 100_000_000;
    static List<Integer> list;
    static List<Edge>[] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            edges = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken()) * 2;
                if ((a == g && b == h) || (a == h && b == g)) c--;
                edges[a].add(new Edge(b, c));
                edges[b].add(new Edge(a, c));
            }
            int[] distance = dijkstra(s);;

            list = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int r = Integer.parseInt(br.readLine());
                if (distance[r] % 2 == 1) list.add(r);
            }
            Collections.sort(list);
            for (int ans : list) {
                sb.append(ans).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] dijkstra(int s) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        distance[s] = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int now = e.next;
            if (visited[now]) continue;
            visited[now] = true;
            for (Edge next : edges[now]) {
                if (visited[next.next]) continue;
                if (distance[next.next] > distance[now] + next.cost) {
                    distance[next.next] = distance[now] + next.cost;
                    pq.add(new Edge(next.next, distance[next.next]));
                }
            }
        }
        return distance;
    }
}
