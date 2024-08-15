package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1240_노드사이의거리 {
    static class Node{
        int number;
        int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int INF = Integer.MAX_VALUE;
        List<Node>[] nodes = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) nodes[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[N + 1];
            visited[s] = true;
            Queue<Node> q = new ArrayDeque<>();
            q.add(new Node(s, 0));
            bfs : while (!q.isEmpty()) {
                Node node = q.poll();
                for (Node next : nodes[node.number]) {
                    if (visited[next.number]) continue;
                    if (next.number == e) {
                        sb.append(node.cost + next.cost).append("\n");
                        break bfs;
                    }
                    visited[next.number] = true;
                    q.add(new Node(next.number, node.cost + next.cost));
                }
            }
        }
        System.out.println(sb);
    }
}
