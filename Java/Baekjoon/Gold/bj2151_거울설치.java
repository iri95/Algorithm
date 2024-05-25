package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class bj2151_거울설치 {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};

    static class Point {
        int y;
        int x;
        int d;
        int count;

        public Point(int y, int x, int d, int count) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        int[][] point = new int[2][2];
        int cnt = 0;
        int m = 0;
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = a.charAt(j);
                if (map[i][j] == '#') {
                    point[cnt][0] = i;
                    point[cnt][1] = j;
                    cnt++;
                } else if (map[i][j] == '!') m++;
            }
        }
        int[][][] values = new int[N][N][4];
        int INF = 2501;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(values[i][j], INF);
            }
        }
        Queue<Point> q = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            q.add(new Point(point[0][0], point[0][1], i, 0));
        }
        while (!q.isEmpty()) {
            Point p = q.poll();
            int ny = p.y + dy[p.d];
            int nx = p.x + dx[p.d];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == '*' || values[ny][nx][p.d] < p.count) continue;
            q.add(new Point(ny, nx, p.d, p.count));
            values[ny][nx][p.d] = p.count;
            if (ny == point[1][0] && nx == point[1][1]) continue;
            if (map[ny][nx] == '!') {
                q.add(new Point(ny, nx, (p.d + 3) % 4, p.count + 1));
                q.add(new Point(ny, nx, (p.d + 1) % 4, p.count + 1));
            }

        }
        int ans = INF;
        for (int i = 0; i < 4; i++) {
            ans = Math.min(values[point[1][0]][point[1][1]][i], ans);
        }
        System.out.println(ans);
    }
}
