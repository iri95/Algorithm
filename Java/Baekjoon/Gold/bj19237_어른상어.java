package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19237_어른상어 {
    static class Shark {
        int x, y, d = 0;
        int[][] direction = new int[5][4];

        Shark(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M, K, count, time = 0;
    static Shark[] sharks;
    static int[] dy = {0, -1, 1, 0, 0}, dx = {0, 0, 0, -1, 1};
    static int[][] map;
    static int[][][] smell;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = M;
        sharks = new Shark[M + 1];
        map = new int[N][N];
        smell = new int[N][N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                smell[i][j][1] = -K;
                if (map[i][j] != 0) {
                    sharks[map[i][j]] = new Shark(i, j);
                    smell[i][j][0] = map[i][j];
                    smell[i][j][1] = 0;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++)
            sharks[i].d = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++)
                    sharks[i].direction[j][k] = Integer.parseInt(st.nextToken());
            }
        }

        while (count != 1 && time <= 1000) {
            time++;
            findDirection();
            remainSmell();
        }

        System.out.println(time > 1000 ? -1 : time);
    }

    private static void findDirection() {
        for (int s = 1; s <= M; s++) {
            Shark cur = sharks[s];
            if (cur == null) continue;
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int nd = cur.direction[cur.d][i];
                int ny = cur.y + dy[nd];
                int nx = cur.x + dx[nd];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (time - smell[ny][nx][1] > K) {
                    flag = true;
                    move(s, cur, nd, ny, nx);
                    break;
                }
            }

            if (!flag) {
                for (int i = 0; i < 4; i++) {
                    int nd = cur.direction[cur.d][i];
                    int ny = cur.y + dy[nd];
                    int nx = cur.x + dx[nd];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                    if (smell[ny][nx][0] == s) {
                        move(s, cur, nd, ny, nx);
                        break;
                    }
                }
            }
        }
    }

    private static void move(int s, Shark cur, int nd, int ny, int nx) {
        map[cur.y][cur.x] = 0;
        if (map[ny][nx] == 0 || map[ny][nx] > s) {
            cur.y = ny;
            cur.x = nx;
            cur.d = nd;
            map[ny][nx] = s;
        } else {
            sharks[s] = null;
            count--;
        }
    }

    private static void remainSmell() {
        for (int s = 1; s <= M; s++) {
            Shark cur = sharks[s];
            if (cur == null) continue;
            smell[cur.y][cur.x][0] = s;
            smell[cur.y][cur.x][1] = time;
        }
    }
}
