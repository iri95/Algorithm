package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj16118_달빛여우 {
    static class Node implements Comparable<Node> {
        int num;
        double cost;
        double div;

        public Node(int num, double cost) {
            this.num = num;
            this.cost = cost;
        }

        public Node(int num, double cost, double div) {
            this.num = num;
            this.cost = cost;
            this.div = div;
        }

        public int compareTo(Node o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    static int N, M;
    static double[] wolfDistance, foxDistance;
    static List<Node>[] route;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        route = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            route[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            route[a].add(new Node(b, d, 0));
            route[b].add(new Node(a, d, 0));
        }

        foxDistance = new double[N + 1];
        wolfDistance = new double[N + 1];
        Arrays.fill(foxDistance, Integer.MAX_VALUE);
        Arrays.fill(wolfDistance, Integer.MAX_VALUE);
        foxDistance[1] = 0;
        wolfDistance[1] = 0;
        foxDijkstra();
        wolfDijkstra();
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (foxDistance[i] < wolfDistance[i]) answer++;
        }
        System.out.println(answer);

    }

    static void foxDijkstra() {
        boolean[] visited = new boolean[N + 1];
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.num]) continue;
            visited[now.num] = true;
            for (Node next : route[now.num]) {
                if (foxDistance[next.num] > foxDistance[now.num] + next.cost) {
                    foxDistance[next.num] = foxDistance[now.num] + next.cost;
                    pq.add(new Node(next.num, foxDistance[next.num]));
                }
            }
        }
    }

    static void wolfDijkstra() {
        boolean[][] visited = new boolean[3][N + 1];
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0, 2));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[(int) now.div][now.num]) continue;
            visited[(int) now.div][now.num] = true;
            for (Node next : route[now.num]) {
                if (wolfDistance[next.num] > now.cost + next.cost / now.div) {
                    wolfDistance[next.num] = now.cost + next.cost / now.div;
                    pq.add(new Node(next.num, wolfDistance[next.num], (double) 1 / now.div));
                } else if (!visited[(int) ((double) 1 / now.div)][next.num]) {
                    pq.add(new Node(next.num, now.cost + next.cost / now.div, (double) 1 / now.div));
                }
            }
        }
    }
}
