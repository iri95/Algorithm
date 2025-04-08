package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2887_행성터널 {
    private static class Node implements Comparable<Node> {
        int n, p;

        Node(int n, int p) {
            this.n = n;
            this.p = p;
        }

        public int compareTo(Node n) {
            return this.p - n.p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] X = new Node[N];
        Node[] Y = new Node[N];
        Node[] Z = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X[i] = new Node(i, Integer.parseInt(st.nextToken()));
            Y[i] = new Node(i, Integer.parseInt(st.nextToken()));
            Z[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(X);
        Arrays.sort(Y);
        Arrays.sort(Z);

        int[] xIndex = new int[N];
        int[] yIndex = new int[N];
        int[] zIndex = new int[N];

        for (int i = 0; i < N; i++) {
            xIndex[X[i].n] = i;
            yIndex[Y[i].n] = i;
            zIndex[Z[i].n] = i;
        }

        boolean[] visited = new boolean[N];

        long sum = 0;
        int count = 0;
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        while(count < N){
            Node cur = pq.poll();
            if (visited[cur.n]) continue;
            visited[cur.n] = true;
            sum += cur.p;
            count++;

            int x = xIndex[cur.n];
            int y = yIndex[cur.n];
            int z = zIndex[cur.n];

            int nx = x - 1;
            if (nx >= 0 && !visited[X[nx].n]) pq.add(new Node(X[nx].n, Math.abs(X[nx].p - X[x].p)));

            nx = x + 1;
            if (nx < N && !visited[X[nx].n])pq.add(new Node(X[nx].n, Math.abs(X[nx].p - X[x].p)));

            int ny = y - 1;
            if (ny >= 0 && !visited[Y[ny].n]) pq.add(new Node(Y[ny].n, Math.abs(Y[ny].p - Y[y].p)));

            ny = y + 1;
            if(ny < N && !visited[Y[ny].n]) pq.add(new Node(Y[ny].n, Math.abs(Y[ny].p - Y[y].p)));

            int nz = z - 1;
            if (nz >= 0 && !visited[Z[nz].n]) pq.add(new Node(Z[nz].n, Math.abs(Z[nz].p - Z[z].p)));

            nz = z + 1;
            if (nz < N && !visited[Z[nz].n]) pq.add(new Node(Z[nz].n, Math.abs(Z[nz].p - Z[z].p)));
        }
        System.out.println(sum);
    }
}
