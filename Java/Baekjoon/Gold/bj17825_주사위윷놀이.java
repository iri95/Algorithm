package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17825_주사위윷놀이 {
    static int max;
    static int[] number = new int[10];
    static int[][] map = {
            {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0},
            {10, 13, 16, 19, 25, 30, 35, 40, 0},
            {20, 22, 24, 25, 30, 35, 40, 0},
            {30, 28, 27, 26, 25, 30, 35, 40, 0},
            {25, 30, 35, 40, 0}};
    static boolean[][] visit = new boolean[5][22];
    static int[][] position = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        position[0][1] = number[0];
        if (position[0][1] == 5) {
            position[0][0] = 1;
            position[0][1] = 0;
        }
        visit[position[0][0]][position[0][1]] = true;
        dfs(map[position[0][0]][position[0][1]], 1);
        System.out.println(max);
    }

    static void dfs(int score, int time) {
        if (time == 10) {
            max = Math.max(max, score);
            return;
        }
        for (int i = 0; i < 4; i++) {
            // 만약 도착지에 도착했다면 다른 말 실행
            if (position[i][1] >= map[position[i][0]].length - 1) continue;

            int y = position[i][0];
            int x = position[i][1];
            int ny = y;
            int nx = Math.min(x + number[time], map[y].length - 1);

            // 파란 표시로 이동할 경우
            if (y == 0) {
                if (map[0][nx] == 10) {
                    ny = 1;
                    nx = 0;
                } else if (map[0][nx] == 20) {
                    ny = 2;
                    nx = 0;
                } else if (map[0][nx] == 30) {
                    ny = 3;
                    nx = 0;
                } else if (map[0][nx] == 40) {
                    ny = 4;
                    nx = 3;
                }
            } else {
                if (y == 1) {
                    if (nx >= 4) {
                        ny = 4;
                        nx -= 4;
                    }
                } else if (y == 2) {
                    if (nx >= 3) {
                        ny = 4;
                        nx -= 3;
                    }
                } else if (y == 3) {
                    if (nx >= 4) {
                        ny = 4;
                        nx -= 4;
                    }
                }
            }

            // 다음 위치에 다른 말이있다면 다른 말 이동
            if (nx < map[ny].length - 1 && visit[ny][nx]) continue;

            // 이동할 말의 방문 취소
            visit[y][x] = false;

            // 도착지 이상의 주사위가 나왔을 경우
            if (nx >= map[ny].length - 1) {
                nx = map[ny].length - 1;
                position[i][1] = nx;
                dfs(score + map[ny][nx], time + 1);
                visit[y][x] = true;
                position[i][1] = x;
                position[i][0] = y;
            } else {
                visit[ny][nx] = true;
                position[i][0] = ny;
                position[i][1] = nx;
                dfs(score + map[ny][nx], time + 1);
                visit[ny][nx] = false;
                visit[y][x] = true;
                position[i][1] = x;
                position[i][0] = y;
            }

        }
    }
}
