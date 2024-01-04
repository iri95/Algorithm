package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14503_로봇청소기 {
    static int N, M, y, x, direction;
    static boolean[][] map;
    static boolean[][] clean;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        clean = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = true;
                    clean[i][j] = true;
                }
            }
        }
        int cnt = 0;
        while (true) {
            if (!clean[y][x]) {
                clean[y][x] = true;
                cnt++;
            }
            if (allClean()) {
                int ny = y + dy[(direction + 2) % 4];
                int nx = x + dx[(direction + 2) % 4];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M && !map[ny][nx]) {
                    y = ny;
                    x = nx;
                } else {
                    break;
                }
            } else {
                move();
            }
        }
        System.out.println(cnt);
    }

    static boolean allClean() {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx]) continue;
            if (!clean[ny][nx]) return false;
        }
        return true;
    }

    static void move() {
        direction = (direction + 3) % 4;
        int ny = y + dy[direction];
        int nx = x + dx[direction];
        if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx]) return;
        if (!clean[ny][nx]) {
            y = ny;
            x = nx;
        }
    }
}
