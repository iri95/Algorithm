package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj11779_최소비용구하기2 {
    static class Node implements Comparable<Node> {
        int end;
        int dis;
        List<Integer> list = new ArrayList<>();

        public Node(int e, int d) {
            this.end = e;
            this.dis = d;
        }

        public Node(int e, int d, List<Integer> nodeList) {
            this.end = e;
            this.dis = d;
            this.list.addAll(nodeList);
        }

        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Node>[] nodes = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes[s].add(new Node(e, d));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        Queue<Node> pq = new PriorityQueue<>();
        Node nodeStart = new Node(start, 0);
        nodeStart.list.add(start);
        pq.add(nodeStart);

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.end == end) {
                sb.append(node.dis).append("\n");
                sb.append(node.list.size()).append("\n");
                for (int i = 0; i < node.list.size(); i++) {
                    sb.append(node.list.get(i)).append(" ");
                }
                System.out.println(sb);
                return;
            }
            if (visited[node.end]) continue;
            visited[node.end] = true;
            for (Node next : nodes[node.end]) {
                if (node.dis + next.dis < distance[next.end]) {
                    distance[next.end] = node.dis + next.dis;
                    Node a = new Node(next.end, distance[next.end], node.list);
                    a.list.add(next.end);
                    pq.add(a);
                }
            }
        }
    }
}
