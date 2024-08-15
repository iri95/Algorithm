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

    static int N, M;
    static boolean[] visited;
    static List<Node>[] nodes;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodes = new ArrayList[N + 1];
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
            visited = new boolean[N + 1];
            visited[s] = true;
            sb.append(dfs(s, e, 0)).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int node, int e, int cost){
        if (node == e) return cost;
        for (Node next : nodes[node]) {
            if (visited[next.number]) continue;
            if (next.number == e) return cost + next.cost;
            visited[next.number] = true;
            int re = dfs(next.number, e, cost + next.cost);
            if (re != -1) return re;
        }
        return -1;
    }
}
