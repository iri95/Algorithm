package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17619_개구리점프 {
    private static class Tree implements Comparable<Tree> {
        int number;
        int s;
        int e;

        Tree(int n, int s, int e) {
            this.number = n;
            this.s = s;
            this.e = e;
        }

        public int compareTo(Tree t) {
            return this.s - t.s;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        Queue<Tree> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Tree(i, s, e));
        }

        Queue<int[]> pq2 = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        while (!pq.isEmpty()) {
            Tree t = pq.poll();
            while (!pq2.isEmpty() && pq2.peek()[1] < t.s) pq2.poll();
            if (!pq2.isEmpty()) union(pq2.peek()[0], t.number);
            pq2.add(new int[]{t.number, t.e});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int xp = find(x);
            int yp = find(y);
            if (xp == yp) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);

        if (xp == yp) return;

        if (xp < yp) parent[yp] = xp;
        else parent[xp] = yp;
    }
}
