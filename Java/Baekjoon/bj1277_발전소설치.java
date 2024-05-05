import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1277_발전소설치 {
    static class Node {
        int y;
        int x;
        List<double[]> linked = new ArrayList<>();

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        double M = Double.parseDouble(br.readLine());
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].linked.add(new double[]{b, 0});
            nodes[b].linked.add(new double[]{a, 0});
        }
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double length = Math.sqrt(Math.pow(nodes[j].y - nodes[i].y, 2) + Math.pow(nodes[j].x - nodes[i].x, 2));
                if (length > M) continue;
                nodes[i].linked.add(new double[]{j, length});
                nodes[j].linked.add(new double[]{i, length});
            }
        }
        double[] distance = new double[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        Queue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o[1]));
        pq.add(new double[]{1, 0});
        boolean[] visited = new boolean[N + 1];
        while (!pq.isEmpty()) {
            double[] now = pq.poll();
            int index = (int) now[0];
            if (visited[index]) continue;
            visited[index] = true;
            if (index == N) break;
            for (double[] next : nodes[index].linked) {
                int nextIndex = (int) next[0];
                if (visited[nextIndex]) continue;
                if (distance[nextIndex] > distance[index] + next[1]) {
                    distance[nextIndex] = distance[index] + next[1];
                    pq.add(new double[]{nextIndex, distance[nextIndex]});
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        System.out.println((int) (distance[N] * 1000));

    }
}
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, W;
    static double M, INF = 200001;
    static Point[] plant;
    static boolean[][] connected;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);
        String MLine = br.readLine();
        M = Double.parseDouble(MLine);

        plant = new Point[N + 1];
        connected = new boolean[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            String[] line = br.readLine().split(" ");
            plant[i] = new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        for (int i = 0; i < W; i++) {
            String[] line = br.readLine().split(" ");
            connected[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = true;
            connected[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = true;
        }

        System.out.println(dijstra());
    }

    private static long dijstra() {
        double[] distance = new double[N + 1];
        for (int i = 1; i < N + 1; i++) {
            distance[i] = INF;
        }
        distance[1] = 0;
        for (int i = 2; i < N + 1; i++) {
            if (connected[1][i]) distance[i] = 0;
        }

        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            double minDist = INF;
            int cur = 0;
            for (int j = 1; j < N + 1; j++) {
                    if (!visited[j] && minDist >= distance[j]) {
                        minDist = distance[j];
                        cur = j;
                    }
            }
            if (cur == N) break;
            visited[cur] = true;
            for (int j = 1; j < N + 1; j++) {
                if (j == cur) continue;
                int next = j;
                if (distance[next] > distance[cur] + getDistance(cur, next)) {
                    distance[next] = distance[cur] + getDistance(cur, next);
                }
            }
        }
        return (long) (distance[N] * 1000);
    }

    private static double getDistance(int cur, int next) {
        if (connected[cur][next]) return 0;

        Point src = plant[cur];
        Point dest = plant[next];
        double dist = Math.pow(src.x - dest.x, 2) + Math.pow(src.y - dest.y, 2);
        return Math.sqrt(dist);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
 */