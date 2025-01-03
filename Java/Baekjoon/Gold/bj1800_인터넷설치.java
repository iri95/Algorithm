package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1800_인터넷설치 {
    static int N, P, K;
    static List<int[]>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
        int maxC = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
            maxC = Math.max(maxC, c);
        }
        int s = 0;
        int e = maxC + 1;
        while (s < e) {
            int m = (s + e) / 2;
            if (sol(m)) e = m;
            else s = m + 1;
        }
        System.out.println(e == maxC + 1 ? -1 : e);
    }

    private static boolean sol(int n) {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] k = new int[N + 1];
        Arrays.fill(k, Integer.MAX_VALUE);
        k[1] = 0;
        q.add(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int[] next : list[now[0]]) {
                int cnt = now[1];
                if (next[1] > n) cnt++;
                if (k[next[0]] <= cnt) continue;
                k[next[0]] = cnt;
                q.add(new int[]{next[0], cnt});
            }
        }
        return k[N] <= K;
    }
}
