package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1761_정점들의거리 {
    static int N, high;
    static int[] depth;
    static int[][] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<int[]>[] lists = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) lists[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new int[]{b, c});
            lists[b].add(new int[]{a, c});
        }

        high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        depth = new int[N + 1];
        parent = new int[N + 1][high];
        int[] distance = new int[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int cnt = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while (size-- > 0) {
                int cur = q.poll();
                depth[cur] = cnt;
                for (int[] next : lists[cur]) {
                    if (next[0] == parent[cur][0]) continue;
                    parent[next[0]][0] = cur;
                    distance[next[0]] = next[1] + distance[cur];
                    q.add(next[0]);
                }
            }
        }

        for (int i = 1; i < high; i++)
            for (int j = 1; j <= N; j++)
                parent[j][i] = parent[parent[j][i - 1]][i - 1];


        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(distance[a] + distance[b] - distance[LCA(a, b)] * 2).append("\n");
        }

        System.out.println(sb);
    }

    private static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = high - 1; i >= 0; i--) {
            if (1 << i <= depth[a] - depth[b]) {
                a = parent[a][i];
            }
        }

        if (a == b) return a;

        for (int i = high - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }
}
