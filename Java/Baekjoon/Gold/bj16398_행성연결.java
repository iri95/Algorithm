package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16398_행성연결 {
    private static class Flow implements Comparable<Flow> {
        int s, e, cost;

        Flow(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        public int compareTo(Flow f) {
            return this.cost - f.cost;
        }

    }

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) parent[i] = i;

        Queue<Flow> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i >= j) continue;
                pq.add(new Flow(i, j, cost));
            }
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            Flow f = pq.poll();
            if (union(f.s, f.e))
                answer += f.cost;
        }

        System.out.println(answer);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp == yp) return false;

        if (xp < yp) parent[yp] = xp;
        else parent[xp] = yp;
        return true;
    }
}
