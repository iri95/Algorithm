package lv3;

import java.util.ArrayDeque;
import java.util.Queue;

public class 미로탈출명령어 {
    static class Route{
        int y;
        int x;
        int cnt;
        String route;
        public Route(int y, int x, int cnt, String route){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.route = route;
        }
    }
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] dc = {'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        int distance = Math.abs(y - c) + Math.abs(x - r);
        if (distance > k || (k - distance) % 2 == 1) return "impossible";
        int remain = (k - distance) / 2;
        boolean[][][] visited = new boolean[k + 1][n + 1][m + 1];
        Queue<Route> queue = new ArrayDeque<>();
        queue.add(new Route(y, x, 0, answer));
        while (!queue.isEmpty()) {
            Route route = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = route.y + dy[i];
                int nx = route.x + dx[i];
                int nCnt = route.cnt + 1;
                String nr = route.route + dc[i];
                if (nCnt > k || ny < 1 || ny > m || nx < 1 || nx > n || visited[nCnt][nx][ny]) continue;
                if (nCnt == k && ny == c && nx == r) {
                    answer = nr;
                    break;
                } else {
                    queue.add(new Route(ny, nx, nCnt, nr));
                    visited[nCnt][nx][ny] = true;
                }
            }
            if (!answer.isEmpty()) break;
        }

        return answer;
    }
}
