package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj32069_가로등 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long L = Long.parseLong(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Set<Long> set = new HashSet<>();
        Queue<Long> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            long a = Long.parseLong(st.nextToken());
            set.add(a);
            q.add(a);
            sb.append(count).append("\n");
            cnt++;
            if (cnt >= K) {
                System.out.println(sb);
                return;
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            while (size-- > 0) {
                long p = q.poll();
                for (int i = -1; i <= 1; i += 2) {
                    long a = p + i;
                    if (a < 0 || a > L || set.contains(a)) continue;
                    sb.append(count).append("\n");
                    cnt++;
                    if (cnt >= K) {
                        System.out.println(sb);
                        return;
                    }
                    set.add(a);
                    q.add(a);
                }
            }
        }
        System.out.println(sb);
    }
}
