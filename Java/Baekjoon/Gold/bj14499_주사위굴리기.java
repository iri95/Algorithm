package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14499_주사위굴리기 {
    static int N, M, y, x, K;
    static int[] dice;
    static int[][] map;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;
        map = new int[N][M];
        dice = new int[6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int direction = Integer.parseInt(st.nextToken()) - 1;
            move(direction);
        }

    }

    static void move(int direction) {
        int ny = y + dy[direction];
        int nx = x + dx[direction];
        if (ny < 0 || ny >= N || nx < 0 || nx >= M) return;
        int k = dice[0];
        switch (direction) {
            case 0:
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = k;
                break;
            case 1:
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = k;
                break;
            case 2:
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = k;
                break;
            case 3:
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = k;
                break;
        }
        if (map[ny][nx] == 0) map[ny][nx] = dice[0];
        else {
            dice[0] = map[ny][nx];
            map[ny][nx] = 0;
        }
        y = ny;
        x = nx;
        System.out.println(dice[5]);
    }
}
