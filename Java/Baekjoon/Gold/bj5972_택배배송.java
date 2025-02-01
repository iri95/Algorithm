package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj5972_택배배송 {
    private static class Route implements Comparable<Route>{
        int point;
        int cost;

        public Route(int point, int cost){
            this.point = point;
            this.cost = cost;
        }

        public int compareTo(Route r){
            return this.cost - r.cost;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Route>[] routes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) routes[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            routes[s].add(new Route(e, c));
            routes[e].add(new Route(s, c));
        }

        Queue<Route> pq = new PriorityQueue<>();
        pq.add(new Route(1, 0));
        boolean[] visited = new boolean[N + 1];
        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;
        while (!pq.isEmpty()) {
            Route cur = pq.poll();
            if (cur.point == N) break;
            if (visited[cur.point]) continue;
            visited[cur.point] = true;
            for (Route next : routes[cur.point]) {
                if (visited[next.point]) continue;
                if (cost[next.point] > cur.cost + next.cost){
                    cost[next.point] = cur.cost + next.cost;
                    pq.add(new Route(next.point, cost[next.point]));
                }
            }
        }
        System.out.println(cost[N]);
    }
}
