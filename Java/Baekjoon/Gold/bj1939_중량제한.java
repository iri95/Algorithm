package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1939_중량제한 {
    static int N, M, s, e, min, max;
    static Map<Integer, Integer>[] maps;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new HashMap[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (maps[a] == null) maps[a] = new HashMap<>();
            if (maps[b] == null) maps[b] = new HashMap<>();
            if (maps[a].containsKey(b)) maps[a].put(b, Math.max(maps[a].get(b), c));
            else maps[a].put(b, c);
            if (maps[b].containsKey(a)) maps[b].put(a, Math.max(maps[b].get(a), c));
            else maps[b].put(a, c);
            min = Math.min(c - 1, min);
            max = Math.max(c + 1, max);
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        while (min + 1 < max) {
            int mid = (min + max) / 2;
            if (bfs(mid)) min = mid;
            else max = mid;
        }
        System.out.println(min);
    }

    static boolean bfs(int mid) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];
        visit[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int k : maps[n].keySet()) {
                if (visit[k] || maps[n].get(k) < mid)continue;
                queue.add(k);
                visit[k] = true;
                if (k == e) return true;
            }
        }
        return false;
    }
}
