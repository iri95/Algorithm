package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj4803_트리 {
    static int n;
    static boolean[] visited;
    static List<Integer>[] tree;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 0;
        while (true) {
            T++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            visited = new boolean[n + 1];
            parents = new int[n + 1];
            tree = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                tree[i] = new ArrayList<>();
                parents[i] = i;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[a].add(b);
                tree[b].add(a);
                union(a, b);
            }
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i] || isCycle(i)) continue;
                cnt++;
            }
            if (cnt == 0) sb.append("Case ").append(T).append(": No trees.").append("\n");
            else if (cnt == 1) sb.append("Case ").append(T).append(": There is one tree.").append("\n");
            else sb.append("Case ").append(T).append(": A forest of ").append(cnt).append(" trees.").append("\n");
        }
        System.out.println(sb);

    }

    private static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);

        if (xp > yp) parents[xp] = yp;
        else parents[yp] = xp;
    }

    private static boolean isCycle(int x) {
        visited[x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, -1});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int next : tree[p[0]]) {
                if (next == p[1]) continue;
                if (visited[next]) return true;
                q.add(new int[]{next, p[0]});
                visited[next] = true;
            }
        }
        return false;
    }
}
