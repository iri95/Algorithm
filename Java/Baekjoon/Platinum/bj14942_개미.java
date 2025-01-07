package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj14942_개미 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N + 1];
        for (int i = 1; i <= N; i++) cost[i] = Integer.parseInt(br.readLine());
        List<int[]>[] lists = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) lists[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new int[]{b, c});
            lists[b].add(new int[]{a, c});
        }
        int high = (int) Math.ceil(Math.log(N) / Math.log(2));
        int[][][] parent = new int[N + 1][high][2];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] next : lists[cur]) {
                if (visited[next[0]]) continue;
                visited[next[0]] = true;
                parent[next[0]][0] = new int[]{cur, next[1]};
                q.add(next[0]);
            }
        }

        for (int h = 1; h < high; h++) {
            for (int i = 1; i <= N; i++) {
                parent[i][h][0] = parent[parent[i][h - 1][0]][h - 1][0];
                parent[i][h][1] = parent[parent[i][h - 1][0]][h - 1][1] + parent[i][h - 1][1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int c = cost[i];
            int cave = i;
            for (int h = high - 1; h >= 0; h--) {
                if (cave == 1) break;
                if (parent[cave][h][1] <= c && parent[cave][h][0] != 0){
                    c -= parent[cave][h][1];
                    cave = parent[cave][h][0];
                }
            }
            sb.append(cave).append("\n");
        }
        System.out.println(sb);
    }
}
