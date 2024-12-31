package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj5719_거의최단경로 {
    private static class Node implements Comparable<Node> {
        int index;
        int cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int INF = Integer.MAX_VALUE;
    static int[] distance;
    static boolean[][] removed;
    static List<Node>[] lists;
    static List<Integer>[] removeList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            lists = new ArrayList[N];
            for (int i = 0; i < N; i++) lists[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            distance = new int[N];
            Arrays.fill(distance, INF);
            distance[start] = 0;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                lists[U].add(new Node(V, P));
            }

            Queue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(start, 0));
            boolean[] check = new boolean[N];
            removeList = new ArrayList[N];
            for (int i = 0; i < N; i++) removeList[i] = new ArrayList<>();
            while (!pq.isEmpty()) {
                int cur = pq.poll().index;
                if (check[cur]) continue;
                check[cur] = true;
                for (Node next : lists[cur]) {
                    if (check[next.index]) continue;
                    if (distance[next.index] > next.cost + distance[cur]) {
                        distance[next.index] = next.cost + distance[cur];
                        removeList[next.index].clear();
                        removeList[next.index].add(cur);
                        pq.add(new Node(next.index, distance[next.index]));
                    } else if (distance[next.index] == next.cost + distance[cur])
                        removeList[next.index].add(cur);
                }
            }
            removed = new boolean[N][N];
            remove(start, end);
            Arrays.fill(distance, INF);
            Arrays.fill(check, false);
            distance[start] = 0;

            pq.add(new Node(start, 0));
            while (!pq.isEmpty()) {
                int cur = pq.poll().index;
                if (check[cur]) continue;
                check[cur] = true;
                for (Node next : lists[cur]) {
                    if (removed[cur][next.index]) continue;
                    if (check[next.index]) continue;
                    if (distance[next.index] > next.cost + distance[cur]) {
                        distance[next.index] = next.cost + distance[cur];
                        pq.add(new Node(next.index, distance[next.index]));
                    }
                }
            }

            sb.append(distance[end] == INF ? -1 : distance[end]).append("\n");
        }
        System.out.println(sb);
    }

    private static void remove(int s, int e) {
        if (s == e) return;
        for (int next : removeList[e]) {
            if (removed[next][e]) continue;
            removed[next][e] = true;
            remove(s, next);
        }
    }
}
