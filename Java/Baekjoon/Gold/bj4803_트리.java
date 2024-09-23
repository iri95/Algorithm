package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj4803_트리 {
    static int n;
    static boolean[] visited;
    static List<Integer>[] tree;

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
            sb.append("Case ").append(T).append(": ");
            visited = new boolean[n + 1];
            tree = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) tree[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[a].add(b);
                tree[b].add(a);
            }
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i] || isCycle(i)) continue;
                cnt++;
            }
            if (cnt == 0) sb.append("No trees.").append("\n");
            else if (cnt == 1) sb.append("There is one tree.").append("\n");
            else sb.append("A forest of ").append(cnt).append(" trees.").append("\n");
        }
        System.out.println(sb);

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
