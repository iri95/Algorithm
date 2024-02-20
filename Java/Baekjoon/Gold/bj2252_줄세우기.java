package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2252_줄세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new ArrayList[N + 1];
        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            list[before].add(after);
            parent[after]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (parent[i] ==  0) queue.offer(i);
        }
        boolean[] visit = new boolean[N + 1];
        visit[0] = true;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            visit[p] = true;
            sb.append(p).append(" ");
            for (int k: list[p]) {
                parent[k]--;
                if (parent[k] == 0) queue.offer(k);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
