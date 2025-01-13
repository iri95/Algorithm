package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1960_행렬만들기 {
    private static class Point implements Comparable<Point> {
        int num;
        int count;

        public Point(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int compareTo(Point p) {
            if (this.count == p.count) return this.num - p.num;
            return p.count - this.count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] y = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) y[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Queue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(st.nextToken());
            if (c != 0) pq.add(new Point(i, c));
        }
        boolean flag = true;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            List<Point> list = new ArrayList<>();
            for (int j = 0; j < y[i]; j++) {
                if (pq.isEmpty()) {
                    flag = false;
                    break;
                }
                Point p = pq.poll();
                map[i][p.num] = 1;
                p.count--;
                if (p.count != 0) list.add(p);
            }
            pq.addAll(list);
        }
        if (!pq.isEmpty()) flag = false;


        if (!flag) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(1).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }
}

/*
public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] capacity = new int[2 * N + 2][2 * N + 2]; // source : 0, sink : 2 * N +  1
        int[][] flow = new int[2 * N + 2][2 * N + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = 0, y = 0;
        for (int i = 1; i <= N; i++) {
            capacity[0][i] = Integer.parseInt(st.nextToken());
            x += capacity[0][i];
        }
        st = new StringTokenizer(br.readLine());
        for (int i = N + 1; i <= 2 * N; i++) {
            capacity[i][2 * N + 1] = Integer.parseInt(st.nextToken());
            y += capacity[i][2 * N + 1];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = N + 1; j <= 2 * N; j++) {
                capacity[i][j] = 1;
            }
        }
        // flow를 사용해 배열을 출력한다.
        // 행렬을 구할 수 없는 경우는 전체 흐름의 개수와 행렬의 1의 개수가 다른 경우
        while (true) {
            Queue<Integer> q = new ArrayDeque<>();
            int[] parent = new int[2 * N + 2];
            Arrays.fill(parent, -1);
            parent[0] = 0;
            q.add(0);
            while (!q.isEmpty() && parent[2 * N + 1] == -1) {
                int cur = q.poll();
                for (int i = 1; i <= 2 * N + 1; i++) {
                    if (capacity[cur][i] > flow[cur][i] && parent[i] == -1) {
                        parent[i] = cur;
                        q.add(i);
                    }
                }
            }
            if (parent[2 * N + 1] == -1) break;

            for (int i = 2 * N + 1; i != 0; i = parent[i]) {
                flow[parent[i]][i] += 1;
                flow[i][parent[i]] -= 1;
            }
        }
        int sum = 0;
        for (int i = N + 1; i <= 2 * N; i++) sum += flow[i][2 * N + 1];
        StringBuilder sb = new StringBuilder();
        if (sum != y || sum != x) sb.append(-1);
        else {
            sb.append(1).append("\n");
            for (int i = 1; i <= N; i++) {
                for (int j = N + 1; j <= 2 * N; j++) {
                    sb.append(flow[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
 */