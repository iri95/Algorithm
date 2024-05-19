package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
양방향일 경우 : X -> Y로의 최단 거리는 Y -> X의 최단거리와 같다
단방향일 경우 : X의 다익스트라는 X -> Y의 최단거리, X의 역방향 간선 다익스트라는 Y -> X의 최단거리를 의미
 */
public class bj1238_파티 {
    static int N, M, X;
    static List<Node>[][] list;
    static int[][] distance;

    static class Node implements Comparable<Node> {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[2][N + 1];
        distance = new int[2][N + 1];
        for (int i = 0; i <= N; i++) {
            list[0][i] = new ArrayList<>();
            list[1][i] = new ArrayList<>();
        }

        for (int i = 0; i < 2; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][X] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[0][s].add(new Node(e, t));
            list[1][e].add(new Node(s, t));
        }
        dijkstra(0);
        dijkstra(1);
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, distance[0][i] + distance[1][i]);
        }
        System.out.println(ans);

    }

    static void dijkstra(int dir) {
        Queue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Node(X, 0));
        while (!pq.isEmpty()) {
            int now = pq.poll().num;
            if (visited[now]) continue;
            visited[now] = true;
            for (Node next : list[dir][now]) {
                if (distance[dir][now] + next.cost < distance[dir][next.num]) {
                    distance[dir][next.num] = distance[dir][now] + next.cost;
                    pq.add(new Node(next.num, distance[dir][next.num]));
                }
            }
        }
    }
}
