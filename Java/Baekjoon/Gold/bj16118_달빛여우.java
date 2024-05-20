package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj16118_달빛여우 {
    static class Node implements Comparable<Node> {
        int num;
        double cost;
        double div;

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
    static double[][] distance;
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

        distance = new double[3][N + 1];
        for (int i = 1; i <= 2; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][1] = 0;
        }
        dijkstra(1);
        dijkstra(2);
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[1][i] < distance[2][i]) answer++;
        }
        System.out.println(answer);

    }

    static void dijkstra(int div) {
        boolean[][] visited = new boolean[3][N + 1];
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0, div));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[(int) now.div][now.num]) continue;
            visited[(int) now.div][now.num] = true;
            for (Node next : route[now.num]) {
                if (distance[div][next.num] > now.cost + next.cost / now.div) {
                    distance[div][next.num] = now.cost + next.cost / now.div;
                    pq.add(new Node(next.num, distance[div][next.num], (double) 1 / now.div));
                } else if (!visited[(int) ((double) 1 / now.div)][next.num]) {
                    pq.add(new Node(next.num, now.cost + next.cost / now.div, (double) 1 / now.div));
                }
            }
        }
    }
}
