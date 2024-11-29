package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4386_별자리만들기 {
    static class Node implements Comparable<Node> {
        int s;
        int e;
        double cost;

        public Node(int s, int e, double cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        public int compareTo(Node n) {
            return (int) (this.cost - n.cost);
        }
    }

    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;

        double[][] points = new double[n][2];
        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Double.parseDouble(st.nextToken());
            points[i][1] = Double.parseDouble(st.nextToken());

            for (int j = i - 1; j >= 0; j--)
                pq.add(new Node(i, j, Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2))));
        }

        double sum = 0;
        while (n > 1) {
            Node node = pq.poll();
            if (union(node.s, node.e)) {
                sum += node.cost;
                n--;
            }
        }
        System.out.printf("%.2f", sum);
    }

    private static int find(int x) {
        if (x == parents[x]) return x;
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
