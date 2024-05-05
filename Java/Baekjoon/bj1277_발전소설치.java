import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/source/27595082
public class bj1277_발전소설치 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, W;
    static double M, INF = 200001;
    static Point[] plant;
    static boolean[][] connected;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        M = Double.parseDouble(br.readLine());

        plant = new Point[N + 1];
        connected = new boolean[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            plant[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connected[a][b] = true;
            connected[b][a] = true;
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
                double len = getDistance(cur, next);
                if (len > M) continue;
                distance[next] = Math.min(distance[next], distance[cur] + len);
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