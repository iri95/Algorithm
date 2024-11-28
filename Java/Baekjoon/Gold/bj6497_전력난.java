package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj6497_전력난 {
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;
            parents = new int[m];
            for (int i = 0; i < m; i++) parents[i] = i;
            int sum = 0;
            Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[2]));
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sum += c;
                pq.add(new int[]{s, e, c});
            }
            while (m > 1) {
                int[] route = pq.poll();
                if (union(route[0], route[1])) {
                    sum -= route[2];
                    m--;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int y, int x) {
        int yp = find(y);
        int xp = find(x);
        if (yp == xp) return false;
        if (yp > xp) parents[yp] = xp;
        else parents[xp] = yp;
        return true;
    }
}
