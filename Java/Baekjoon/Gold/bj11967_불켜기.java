package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj11967_불켜기 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Point>[][] points = new ArrayList[N + 1][N + 1];
        boolean[][] light = new boolean[N + 1][N + 1]; // 불이 켜진곳
        boolean[][] visit = new boolean[N + 1][N + 1]; // 방문 가능한 곳
        light[1][1] = true;
        visit[1][1] = true;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                points[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            points[x][y].add(new Point(a, b));
        }
        int ans = 1;

        // 방문 가능한 곳, 연결된 방의 불을 켤 곳
        Queue<Point> queue1 = new ArrayDeque<>();
        queue1.add(new Point(1, 1));

        // 방문 가능해진 곳 주변의 불이 켜졌지만 방문하지 못했던 곳
        Queue<Point> queue2 = new ArrayDeque<>();

        /*
         이동 가능한 곳에서 불을 밝힘
         -> 주변에 이동 가능한 곳이 있는지 확인 (visit)
         -> 있으면 이동 가능 방문(visit) 처리 및 불 밝히는 큐에 넣기(queue1)
         -> 이동 가능 방문 처리 시(visit) 주변에 이동 불가능했던 불켜진 곳(!visit && light)이 있는지 탐색
         -> 없으면 블을 켠 처리(light)
         */
        while (!queue1.isEmpty()) {
            Point point = queue1.poll();
            for (Point p : points[point.x][point.y]) {
                if (!light[p.x][p.y]) {
                    ans++;
                    light[p.x][p.y] = true;
                    for (int i = 0; i < 4; i++) {
                        int ny = p.y + dy[i];
                        int nx = p.x + dx[i];
                        if (ny < 1 || ny > N || nx < 1 || nx > N || !visit[nx][ny]) continue;
                        visit[p.x][p.y] = true;
                        queue1.add(new Point(p.x, p.y));
                        break;
                    }
                    if (visit[p.x][p.y]) {
                        queue2.add(new Point(p.x, p.y));
                        while (!queue2.isEmpty()) {
                            Point p2 = queue2.poll();
                            for (int i = 0; i < 4; i++) {
                                int ny = p2.y + dy[i];
                                int nx = p2.x + dx[i];
                                if (ny < 1 || ny > N || nx < 1 || nx > N || visit[nx][ny] || !light[nx][ny]) continue;
                                visit[nx][ny] = true;
                                queue1.add(new Point(nx, ny));
                                queue2.add(new Point(nx, ny));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
