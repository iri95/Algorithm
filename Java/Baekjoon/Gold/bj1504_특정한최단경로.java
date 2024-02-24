package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/source/61489722
public class bj1504_특정한최단경로 {

    static class Node implements Comparable<Node> {
        int index;
        int distance;
        List<Integer> list = new ArrayList<>();

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static int N;
    static int max = 200_000_001;
    static int[] distanceList;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        distanceList = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int rs1 = 0;
        int rs2 = 0;
        dijkstra(1);
        rs1 += distanceList[v1];
        rs2 += distanceList[v2];

        dijkstra(v1);
        rs1 += distanceList[v2];
        rs2 += distanceList[N];

        dijkstra(v2);
        rs1 += distanceList[N];
        rs2 += distanceList[v1];

        System.out.println(Math.min(rs1, rs2) >= max ? -1 : Math.min(rs1, rs2));
    }

    static void dijkstra(int a) {
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        pq.add(new Node(a, 0));
        boolean[] visit = new boolean[N + 1];
        distanceList = new int[N + 1];
        Arrays.fill(distanceList, max);
        distanceList[a] = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            visit[n.index] = true;
            for (Node node : graph.get(n.index)) {
                if (!visit[node.index] && distanceList[node.index] > n.distance + node.distance) {
                    distanceList[node.index] = n.distance + node.distance;
                    pq.add(new Node(node.index, distanceList[node.index]));
                }
            }

        }
    }
}
