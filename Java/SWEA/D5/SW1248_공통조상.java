package D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SW1248_공통조상 {
    static int V, E, a, b;
    static int[] parents;
    static boolean[] visited;
    static List<Integer>[] child;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            parents = new int[V + 1];
            visited = new boolean[V + 1];
            child = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++) {
                child[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                child[p].add(c);
                parents[c] = p;
            }
            visit(a);
            int ans = visit(b);
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(ans);
            int count = 1;
            while (!queue.isEmpty()) {
                int n = queue.poll();
                count += child[n].size();
                for (int k : child[n]) {
                    queue.add(k);
                }
            }
            sb.append("#").append(t).append(" ")
                    .append(ans).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    static int visit(int n) {
        if (visited[n]) return n;
        if (n == parents[n]) return 0;
        visited[n] = true;
        return visit(parents[n]);
    }
}
