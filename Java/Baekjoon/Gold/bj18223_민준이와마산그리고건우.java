package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 출발지 -> 도착지의 값과 출발지 -> 건우 -> 도착지의 값이 같아야 함.
public class bj18223_민준이와마산그리고건우 {
    private static class Node implements Comparable<Node>{
        int num;
        int distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
        public int compareTo(Node node){
            return this.distance - node.distance;
        }
    }
    static int V;
    static List<Node>[] nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        nodes = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) nodes[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }
        int[] mDistance = new int[V + 1];
        int[] gDistance = new int[V + 1];
        Arrays.fill(mDistance, 50_000_000);
        Arrays.fill(gDistance, 50_000_000);
        mDistance[1] = 0;
        gDistance[P] = 0;
        dijkstra(1, mDistance);
        dijkstra(P, gDistance);
        if (mDistance[V] == gDistance[V] + mDistance[P]) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }

    private static void dijkstra(int start, int[] dis) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        boolean[] visited = new boolean[V + 1];
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.num]) continue;
            visited[node.num] = true;
            for (Node next : nodes[node.num]) {
                if (visited[next.num]) continue;
                if (dis[next.num] > node.distance + next.distance) {
                    dis[next.num] = node.distance + next.distance;
                    pq.add(new Node(next.num, dis[next.num]));
                }
            }
        }
    }
}
