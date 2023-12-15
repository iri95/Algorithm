package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20056_마법사상어와파이어볼 {

    static int N, M, K;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; // 0, 1, 2, 3, 4, 5, 6, 7
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static FireBall[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new FireBall[N][N];
        int result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = new FireBall(1, 0, m, s, d);
        }
        while (K-- > 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == null || map[i][j].count == 0) continue;
                    if (map[i][j].count - map[i][j].move > 0) {
                        if (map[i][j].four) {
                            map[i][j].four = false;
                            for (int k = 0; k < 4; k++) {
                                move(i, j);
                            }
                        } else {
                            move(i, j);
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == null) continue;
                    map[i][j].move = 0;
                    if (map[i][j].count > 1) {
                        divide(i, j);
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == null || map[i][j].count == 0) continue;
                if (map[i][j].count > 1) {
                    for (int k = 0; k < map[i][j].count; k++) {
                        result += map[i][j].queue.poll()[0];
                    }
                } else {
                    result += map[i][j].queue.poll()[0];
                }
            }
        }
        System.out.println(result);
    }

    // FireBall 클래스
    public static class FireBall {
        int count; // count가 2이상이면 나눈다.
        int move; // 여기로 이동한 수
        Queue<int[]> queue = new ArrayDeque<>(); // m, s, d
        boolean four = false;


        public FireBall() {
            this.count = 0;
            this.move = 0;
            this.queue.offer(new int[]{0, 0, 0});
        }

        public FireBall(int count, int move, int m, int s, int d) {
            this.count = count;
            this.move = move;
            this.queue.offer(new int[]{m, s, d});
        }
    }

    // count 1 이상인 fireball 이동
    static void move(int y, int x) {
        map[y][x].count--;
        int[] value = map[y][x].queue.poll();
        int ny = (y + dy[value[2]] * value[1]) % N;
        int nx = (x + dx[value[2]] * value[1]) % N;
        ny = ny >= 0 ? ny : N + ny;
        nx = nx >= 0 ? nx : N + nx;
        if (map[ny][nx] == null) {
            map[ny][nx] = new FireBall(1, 1, value[0], value[1], value[2]);
        } else {
            map[ny][nx].queue.offer(new int[]{value[0], value[1], value[2]});
            map[ny][nx].count++;
            map[ny][nx].move++;
        }
    }

    // 모든 이동 후 conut 2 이상인 FireBall 질량 0 이면 제거
    static void divide(int y, int x) {
        int size = map[y][x].count;
        int mSum = 0;
        int sSum = 0;
        boolean all = true;
        int allInt = map[y][x].queue.peek()[2] % 2;
        for (int i = 0; i < size; i++) {
            int[] list = map[y][x].queue.poll();
            mSum += list[0];
            sSum += list[1];
            if (list[2] % 2 != allInt) {
                all = false;
            }
        }
        if (mSum / 5 == 0) {
            map[y][x].count = 0;
            map[y][x].queue.clear();
        } else {
            map[y][x].count = 4;
            map[y][x].queue.clear();
            map[y][x].four = true;
            if (all) {
                map[y][x].queue.offer(new int[]{mSum / 5, sSum / size, 0});
                map[y][x].queue.offer(new int[]{mSum / 5, sSum / size, 2});
                map[y][x].queue.offer(new int[]{mSum / 5, sSum / size, 4});
                map[y][x].queue.offer(new int[]{mSum / 5, sSum / size, 6});
            } else {
                map[y][x].queue.offer(new int[]{mSum / 5, sSum / size, 1});
                map[y][x].queue.offer(new int[]{mSum / 5, sSum / size, 3});
                map[y][x].queue.offer(new int[]{mSum / 5, sSum / size, 5});
                map[y][x].queue.offer(new int[]{mSum / 5, sSum / size, 7});
            }
        }
    }
}
