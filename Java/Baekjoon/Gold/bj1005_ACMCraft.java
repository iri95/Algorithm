package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1005_ACMCraft {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] time = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer>[] after = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; i++) {
                after[i] = new ArrayList<>();
            }
            int[] cnt = new int[N + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                after[a].add(b);
                cnt[b]++;
            }
            int value = Integer.parseInt(br.readLine());
            int[] answer = new int[N + 1];
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (cnt[i] == 0) {
                    queue.offer(i);
                    answer[i] = time[i];
                }
            }
            while (!queue.isEmpty()) {
                int k = queue.poll();
                if (k == value) break;
                for (int next: after[k]) {
                    answer[next] = Math.max(time[next] + answer[k], answer[next]);
                    cnt[next]--;
                    if (cnt[next] == 0) queue.offer(next);
                }
            }
            sb.append(answer[value]).append("\n");
        }
        System.out.println(sb);
    }
}
