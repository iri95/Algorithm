package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj11437_LCA {
    static int N;
    static int[] parents, depth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        depth = new int[N + 1];
        List<Integer>[] nodes = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) nodes[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int d = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            d++;
            while (size-- > 0) {
                int node = q.poll();
                for (int next : nodes[node]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    parents[next] = node;
                    depth[next] = d;
                    q.add(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (depth[a] >= depth[b]) sb.append(find(a, b)).append("\n");
            else sb.append(find(b, a)).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int y, int x) {
        int diffDepth = depth[y] - depth[x];
        for (int i = 0; i < diffDepth; i++) y = parents[y];

        while (y != x) {
            y = parents[y];
            x = parents[x];
        }

        return x;
    }
}
