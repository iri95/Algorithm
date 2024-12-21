package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj8012_한동이는영업사원 {
    static int high;
    static int[] depth;
    static int[][] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        depth = new int[N + 1];
        parent = new int[N + 1][high];

        List<Integer>[] lists = new ArrayList[N + 1];
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
        int h = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                depth[cur[0]] = h;
                for (int next : lists[cur[0]]) {
                    if (cur[1] == next) continue;
                    parent[next][0] = cur[0];
                    q.add(new int[]{next, cur[0]});
                }
            }
            h++;
        }

        for (int i = 1; i < high; i++)
            for (int j = 1; j <= N; j++)
                parent[j][i] = parent[parent[j][i - 1]][i - 1];

        int cur = 1;
        int ans = 0;
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            int next = Integer.parseInt(br.readLine());
            ans += depth[cur] + depth[next] - 2 * depth[LCA(cur, next)];
            cur = next;
        }
        System.out.println(ans);

    }
    private static int LCA(int a, int b){
        if (depth[a] > depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = high - 1; i >= 0; i--)
            if (1 << i <= depth[b] - depth[a]) b = parent[b][i];

        if (a == b) return a;

        for (int i = high - 1; i >= 0; i--){
            if (parent[a][i] != parent[b][i]){
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }
}
