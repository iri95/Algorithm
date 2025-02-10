package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj14621_나만안되는연애 {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] male = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            if (st.nextToken().equals("M")) male[i] = true;

        Queue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if ((male[s] && !male[e]) || (!male[s] && male[e])) pq.add(new Edge(s, e, cost));
        }

        int count = 0;
        int answer = 0;
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) parent[i] = i;

        while (!pq.isEmpty() && count != N - 1) {
            Edge edge = pq.poll();
            if (union(edge.start, edge.end)) {
                answer += edge.cost;
                count++;
            }
        }

        if (count == N - 1) System.out.println(answer);
        else System.out.println(-1);
    }
    private static int find(int n){
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static boolean union(int x, int y){
        int xp = find(x);
        int yp = find(y);
        if (xp == yp) return false;

        if (xp < yp) parent[yp] = xp;
        else parent[xp] = yp;
        return true;
    }
}
