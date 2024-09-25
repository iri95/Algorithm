package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj15971_두로봇 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R1 = Integer.parseInt(st.nextToken());
        int R2 = Integer.parseInt(st.nextToken());
        if (R1 == R2) {
            System.out.println(0);
            return;
        }
        int[] cost1 = new int[N + 1];
        List<int[]>[] list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{R1, 0});
        boolean[] visited = new boolean[N + 1];
        cost1[R1] = 0;
        visited[R1] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int[] next : list[p[0]]) {
                if (visited[next[0]]) continue;
                cost1[next[0]] = p[1] + next[1];
                visited[next[0]] = true;
                q.add(new int[]{next[0], p[1] + next[1]});
            }
        }
        q.add(new int[]{R2, 0});
        Arrays.fill(visited, false);
        visited[R2] = true;
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int[] next : list[p[0]]) {
                if (visited[next[0]]) continue;
                ans = Math.min(ans, p[1] + cost1[next[0]]);
                visited[next[0]] = true;
                q.add(new int[]{next[0], p[1] + next[1]});
            }
        }
        System.out.println(ans);
    }
}
