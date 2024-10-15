package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1766_문제집 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cnt = new int[N + 1];
        List<Integer>[] back = new ArrayList[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (back[a] == null) back[a] = new ArrayList<>();
            back[a].add(b);
            cnt[b]++;
        }

        Queue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i <= N; i++)
            if (cnt[i] == 0) q.add(i);

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int p = q.poll();
            sb.append(p).append(" ");
            if (back[p] == null) continue;
            for (int next : back[p]) {
                cnt[next]--;
                if (cnt[next] == 0) q.add(next);
            }
        }
        System.out.println(sb);
    }
}