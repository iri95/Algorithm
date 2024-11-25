package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1774_우주신과의교감 {
    private static class Route implements Comparable<Route> {
        int num1;
        int num2;
        double cost;

        public Route(int num1, int num2, double cost) {
            this.num1 = num1;
            this.num2 = num2;
            this.cost = cost;
        }

        public int compareTo(Route g) {
            return (int) Math.round((this.cost - g.cost) * 100);
        }
    }

    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) parents[i] = i;

        int[][] point = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        Queue<Route> pq = new PriorityQueue<>();

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double cost = Math.sqrt(Math.pow(point[i][0] - point[j][0], 2) + Math.pow(point[i][1] - point[j][1], 2));
                pq.add(new Route(i, j, cost));
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if (union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) cnt++;
        }

        double sum = 0;

        while (cnt < N - 1) {
            Route r = pq.poll();
            if (union(r.num1, r.num2)) {
                sum += r.cost;
                cnt++;
            }

        }

        System.out.printf("%.2f%n", sum);
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int y, int x) {
        int yp = find(y);
        int xp = find(x);
        if (yp == xp) return false;
        if (yp < xp) parents[xp] = yp;
        else parents[yp] = xp;
        return true;
    }
}
