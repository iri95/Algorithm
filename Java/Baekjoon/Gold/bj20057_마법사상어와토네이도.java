package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20057_마법사상어와토네이도 {
    static int N, y, x, outSum = 0, remain = 0, direction = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int[][] spreadXY = {
            {-1, 1, -2, 2, -1, 1, -1, 1, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2},
            {-1, 1, -2, 2, -1, 1, -1, 1, 0},
            {1, 1, 0, 0, 0, 0, -1, -1, -2}
    };
    static int[] spread = {1, 1, 2, 2, 7, 7, 10, 10, 5};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        y = N / 2;
        x = N / 2;
        int count = 1;
        while (count / 2 < N) {
            count++;
            for (int i = 0; i < count / 2 && i < N - 1; i++) {
                y += dy[direction];
                x += dx[direction];
                windy();
                map[y][x] = 0;
            }
            direction = (direction + 1) % 4;
        }
        System.out.println(outSum);
    }

    static void windy() {
        remain = map[y][x];
        int ny;
        int nx;
        for (int i = 0; i < 9; i++) {
            ny = y + spreadXY[direction][i];
            nx = x + spreadXY[(direction + 3) % 4][i];
            remain -= map[y][x] * spread[i] / 100;
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) outSum += map[y][x] * spread[i] / 100;
            else map[y + spreadXY[direction][i]][x + spreadXY[(direction + 3) % 4][i]] += map[y][x] * spread[i] / 100;
        }
        ny = y + dy[direction];
        nx = x + dx[direction];
        if (ny < 0 || ny >= N || nx < 0 || nx >= N) outSum += remain;
        else map[ny][nx] += remain;

    }

}
