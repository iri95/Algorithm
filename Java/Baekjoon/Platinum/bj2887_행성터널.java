package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2887_행성터널 {
    private static class Node implements Comparable<Node> {
        int n, p;

        Node(int n, int p) {
            this.n = n;
            this.p = p;
        }

        public int compareTo(Node n) {
            return this.p - n.p;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int start, end, cost;

        Edge(int s, int e, int c) {
            this.start = s;
            this.end = e;
            this.cost = c;
        }

        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        List<Node> X = new ArrayList<>();
        List<Node> Y = new ArrayList<>();
        List<Node> Z = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            X.add(new Node(i, x));
            Y.add(new Node(i, y));
            Z.add(new Node(i, z));
            parent[i] = i;
        }

        Collections.sort(X);
        Collections.sort(Y);
        Collections.sort(Z);

        Queue<Edge> pq = new PriorityQueue<>();

        for (int i = 1; i < N; i++) {
            pq.add(new Edge(X.get(i - 1).n, X.get(i).n, Math.abs(X.get(i - 1).p - X.get(i).p)));
            pq.add(new Edge(Y.get(i - 1).n, Y.get(i).n, Math.abs(Y.get(i - 1).p - Y.get(i).p)));
            pq.add(new Edge(Z.get(i - 1).n, Z.get(i).n, Math.abs(Z.get(i - 1).p - Z.get(i).p)));
        }

        int count = 0;
        long sum = 0;
        while(count < N - 1){
            Edge cur = pq.poll();
            if (union(cur.start, cur.end)) {
                sum += cur.cost;
                count++;
            }
        }
        System.out.println(sum);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;

        if (px < py)parent[py] = px;
        else parent[px] = py;
        return true;
    }
}