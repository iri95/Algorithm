package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj11438_LCA2 {
    static int N, H;
    static int[] depth;
    static List<Integer>[] lists;
    static int[][] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        lists = new ArrayList[N + 1];
        depth = new int[N + 1];
        parents = new int[N + 1][H];
        for (int i = 0; i <= N; i++) lists[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while (size-- > 0) {
                int[] cur = q.poll();
                depth[cur[0]] = cnt;
                for (int next : lists[cur[0]]) {
                    if (next == cur[1]) continue;
                    parents[next][0] = cur[0];
                    q.add(new int[]{next, cur[0]});
                }
            }
        }

        for (int i = 1; i < H; i++)
            for (int j = 1; j <= N; j++)
                parents[j][i] = parents[parents[j][i - 1]][i - 1];

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = H - 1; i >= 0; i--)
            if (1 << i <= depth[a] - depth[b]) a = parents[a][i];

        if (a == b) return a;

        for (int i = H - 1; i >= 0; i--) {
            if (parents[a][i] != parents[b][i]) {
                a = parents[a][i];
                b = parents[b][i];
            }
        }
        return parents[a][0];
    }
}
