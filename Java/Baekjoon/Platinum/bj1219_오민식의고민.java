package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1219_오민식의고민 {
    private static class Edge {
        int start, end, cost;

        Edge(int s, int e, int c) {
            this.start = s;
            this.end = e;
            this.cost = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s, e, c);
        }

        int[] money = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            money[i] = Integer.parseInt(st.nextToken());

        long INF = Long.MIN_VALUE;
        long[] dist = new long[N];
        Arrays.fill(dist, INF);
        dist[S] = money[S];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int s = edges[j].start;
                int e = edges[j].end;
                int c = edges[j].cost;
                int m = money[e];
                if (dist[s] != INF && dist[e] < dist[s] - c + m) {
                    dist[e] = dist[s] - c + m;
                }
            }
        }

        boolean flag = false;
        f:
        for (int j = 0; j < M; j++) {
            int s = edges[j].start;
            int e = edges[j].end;
            int c = edges[j].cost;
            int m = money[e];
            if (dist[s] != INF && dist[e] < dist[s] - c + m) {
                Queue<Integer> q = new ArrayDeque<>();
                q.add(e);
                boolean[] visited = new boolean[N];
                visited[e] = true;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    if (cur == E) {
                        flag = true;
                        break f;
                    }

                    for (int i = 0; i < M; i++) {
                        if (visited[edges[i].end]) continue;
                        if (edges[i].start == cur) {
                            visited[edges[i].end] = true;
                            q.add(edges[i].end);
                        }
                    }
                }
            }
        }

        if (dist[E] == INF) System.out.println("gg");
        else if (flag) System.out.println("Gee");
        else System.out.println(dist[E]);
    }
}
