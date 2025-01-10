package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj13511_트리와쿼리2 {
    static int high;
    static int[] depth;
    static long[][][] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<int[]>[] edge = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) edge[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edge[u].add(new int[]{v, w});
            edge[v].add(new int[]{u, w});
        }

        high = (int) Math.ceil(Math.log(N) / Math.log(2));
        parent = new long[N + 1][high][2];
        depth = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        int d = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            d++;
            while (size-- > 0) {
                int cur = q.poll();
                depth[cur] = d;
                for (int[] next : edge[cur]) {
                    if (visited[next[0]]) continue;
                    visited[next[0]] = true;
                    parent[next[0]][0][0] = cur;
                    parent[next[0]][0][1] = next[1];
                    q.add(next[0]);
                }
            }
        }

        for (int i = 1; i < high; i++) {
            for (int j = 2; j <= N; j++) {
                parent[j][i][0] = parent[(int) parent[j][i - 1][0]][i - 1][0];
                parent[j][i][1] = parent[(int) parent[j][i - 1][0]][i - 1][1] + parent[j][i - 1][1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (num == 1) {
                sb.append(getResult(u, v)[0]).append("\n");
            } else {
                int k = Integer.parseInt(st.nextToken());
                long[] result = getResult(u, v);
                if (k > result[2]) {
                    k = (int) result[1] - k + 1;
                    u = v;
                }
                sb.append(findNode(u, k - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    // cost, 총 카운트, u의 count
    private static long[] getResult(int u, int v) {
        long cost = 0;
        long uCount = 1;
        long vCount = 1;
        if (depth[u] < depth[v]) {
            for (int i = high - 1; i >= 0; i--) {
                if (depth[v] - depth[u] >= 1 << i) {
                    cost += parent[v][i][1];
                    v = (int) parent[v][i][0];
                    vCount += 1L << i;
                }
            }
        } else if (depth[u] > depth[v]) {
            for (int i = high - 1; i >= 0; i--) {
                if (depth[u] - depth[v] >= 1 << i) {
                    cost += parent[u][i][1];
                    u = (int) parent[u][i][0];
                    uCount += 1L << i;
                }
            }
        }

        if (v == u) return new long[]{cost, uCount + vCount - 1, uCount};

        for (int i = high - 1; i >= 0; i--) {
            if (parent[u][i][0] != parent[v][i][0]) {
                cost += parent[u][i][1];
                cost += parent[v][i][1];
                u = (int) parent[u][i][0];
                v = (int) parent[v][i][0];
                uCount += 1L << i;
                vCount += 1L << i;
            }
        }

        return new long[]{cost + parent[u][0][1] + parent[v][0][1], uCount + vCount + 1, uCount + 1};
    }

    private static int findNode(int n, int k) {
        for (int i = high - 1; i >= 0; i--) {
            if (1 << i <= k) {
                k -= 1 << i;
                n = (int) parent[n][i][0];
            }
        }
        return n;
    }
}

