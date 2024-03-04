package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2623_음악프로그램 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] before = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            before[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int b = 0;
            for (int j = 0; j < t; j++) {
                int be = Integer.parseInt(st.nextToken());
                before[be].add(b);
                b = be;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];
        visit[0] = true;
        for (int i = 1; i <= N; i++) {
            if (before[i].size() == 1 && before[i].get(0) == 0) {
                queue.add(i);
                visit[i] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int p = queue.poll();
            sb.append(p).append("\n");
            for (int i = 1; i <= N; i++) {
                if (visit[i]) continue;
                boolean cant = false;
                for (int s : before[i]) {
                    if (!visit[s]) {
                        cant = true;
                        break;
                    }
                }
                if (cant) continue;
                queue.add(i);
                visit[i] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb);
    }
}
