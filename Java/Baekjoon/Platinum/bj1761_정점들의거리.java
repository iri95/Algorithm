package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1761_정점들의거리 {
    static int N, high;
    static int[] depth;
    static int[][][] parent;

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

        // parent는 2^i 조상을 저장. 자식이 1개만 있는 최악의 경우에도 parent 배열에서 index out이 발생하지 않도록 해야함.
        high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        depth = new int[N + 1];
        parent = new int[N + 1][high][2]; // 조상 노드의 노드 번호, 비용을 저장
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
                    if (next[0] == parent[cur][0][0]) continue;
                    parent[next[0]][0][0] = cur;
                    parent[next[0]][0][1] = next[1];
                    q.add(next[0]);
                }
            }
        }

        for (int i = 1; i < high; i++) {
            for (int j = 1; j <= N; j++) {
                parent[j][i][0] = parent[parent[j][i - 1][0]][i - 1][0];
                parent[j][i][1] = parent[j][i - 1][1] + parent[parent[j][i - 1][0]][i - 1][1];
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    private static int LCA(int a, int b){
        if (depth[a] < depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }

        int ans = 0;
        for (int i = high - 1; i >= 0; i--) {
            if (1 << i <= depth[a] - depth[b]){
                ans += parent[a][i][1];
                a = parent[a][i][0];
            }
        }

        if (a == b) return ans;

        for (int i = high - 1; i >= 0; i--){
            if (parent[a][i][0] != parent[b][i][0]){
                ans += parent[a][i][1] + parent[b][i][1];
                a = parent[a][i][0];
                b = parent[b][i][0];
            }
        }

        return ans + parent[a][0][1] + parent[b][0][1];
    }
}
