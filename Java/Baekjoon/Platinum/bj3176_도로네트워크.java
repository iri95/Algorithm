package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj3176_도로네트워크 {
    static int high;
    static int[] depth;
    static int[][][] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        high = (int) Math.ceil(Math.log(N) / Math.log(2));
        depth = new int[N + 1];
        parent = new int[N + 1][high][3]; // 부모 노드, 그 사이의 최소 길이, 최대 길이
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

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int h = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                depth[cur] = h;
                for (int[] next : lists[cur]) {
                    if (next[0] == parent[cur][0][0]) continue;
                    parent[next[0]][0][0] = cur;
                    parent[next[0]][0][1] = parent[next[0]][0][2] = next[1];
                    q.add(next[0]);
                }
            }
            h++;
        }

        for (int i = 1; i < high; i++) {
            for (int j = 1; j <= N; j++) {
                parent[j][i][0] = parent[parent[j][i - 1][0]][i - 1][0];
                parent[j][i][1] = Math.min(parent[j][i - 1][1], parent[parent[j][i - 1][0]][i - 1][1]);
                parent[j][i][2] = Math.max(parent[j][i - 1][2], parent[parent[j][i - 1][0]][i - 1][2]);
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] ans = LCA(a, b);
            sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
        }
        System.out.println(sb);

    }

    private static int[] LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        int min = 1_000_001;
        int max = 0;

        for (int i = high - 1; i >= 0; i--) {
            if (depth[a] - depth[b] >= 1 << i) {
                min = Math.min(min, parent[a][i][1]);
                max = Math.max(max, parent[a][i][2]);
                a = parent[a][i][0];
            }
        }
        if (a == b) return new int[]{min, max};

        for (int i = high - 1; i >= 0; i--) {
            if (parent[a][i][0] != parent[b][i][0]) {
                min = Math.min(min, parent[a][i][1]);
                max = Math.max(max, parent[a][i][2]);
                a = parent[a][i][0];
                min = Math.min(min, parent[b][i][1]);
                max = Math.max(max, parent[b][i][2]);
                b = parent[b][i][0];
            }
        }
        min = Math.min(min, Math.min(parent[a][0][1], parent[b][0][1]));
        max = Math.max(max, Math.max(parent[a][0][2], parent[b][0][2]));

        return new int[]{min, max};
    }
}
