package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj15591_MooTube_Silver {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        List<int[]>[] lists = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) lists[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int q1 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            lists[q1].add(new int[]{q2, r});
            lists[q2].add(new int[]{q1, r});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new ArrayDeque<>();
            q.add(v);
            int count = 0;
            boolean[] visited = new boolean[N + 1];
            visited[v] = true;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int[] next : lists[cur]) {
                    if (next[1] < k || visited[next[0]]) continue;
                    visited[next[0]] = true;
                    count++;
                    q.add(next[0]);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
