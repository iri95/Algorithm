package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj15653_구슬탈출4 {
    static int N, M;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M]; // 빨간공, 파란공의 좌표, 방문 처리
        int ry = 0, rx = 0, by = 0, bx = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    ry = i;
                    rx = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    by = i;
                    bx = j;
                    map[i][j] = '.';
                }
            }
        }
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{ry, rx, by, bx});
        visited[ry][rx][by][bx] = true;
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] p = q.poll();
                // dir == 0 R
                int[] red = move(p[0], p[1], 0);
                int[] blue = move(p[2], p[3], 0);
                if (red[0] == -1) {
                    if (blue[0] != -1) {
                        System.out.println(count);
                        return;
                    }
                } else if (blue[0] != -1){
                    if (red[0] == blue[0] && red[1] == blue[1]) {
                        if (p[1] >= p[3]) blue[1]--;
                        else red[1]--;
                    }
                    if (!visited[red[0]][red[1]][blue[0]][blue[1]]) {
                        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                        q.add(new int[]{red[0], red[1], blue[0], blue[1]});
                    }
                }
                // L
                red = move(p[0], p[1], 1);
                blue = move(p[2], p[3], 1);
                if (red[0] == -1) {
                    if (blue[0] != -1) {
                        System.out.println(count);
                        return;
                    }
                } else  if (blue[0] != -1){
                    if (red[0] == blue[0] && red[1] == blue[1]) {
                        if (p[1] <= p[3]) blue[1]++;
                        else red[1]++;
                    }
                    if (!visited[red[0]][red[1]][blue[0]][blue[1]]) {
                        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                        q.add(new int[]{red[0], red[1], blue[0], blue[1]});
                    }
                }

                // D
                red = move(p[0], p[1], 2);
                blue = move(p[2], p[3], 2);
                if (red[0] == -1) {
                    if (blue[0] != -1) {
                        System.out.println(count);
                        return;
                    }
                } else  if (blue[0] != -1){
                    if (red[0] == blue[0] && red[1] == blue[1]) {
                        if (p[0] >= p[2]) blue[0]--;
                        else red[0]--;
                    }
                    if (!visited[red[0]][red[1]][blue[0]][blue[1]]) {
                        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                        q.add(new int[]{red[0], red[1], blue[0], blue[1]});
                    }
                }

                // U
                red = move(p[0], p[1], 3);
                blue = move(p[2], p[3], 3);
                if (red[0] == -1) {
                    if (blue[0] != -1) {
                        System.out.println(count);
                        return;
                    }
                } else  if (blue[0] != -1){
                    if (red[0] == blue[0] && red[1] == blue[1]) {
                        if (p[0] <= p[2]) blue[0]++;
                        else red[0]++;
                    }
                    if (!visited[red[0]][red[1]][blue[0]][blue[1]]) {
                        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                        q.add(new int[]{red[0], red[1], blue[0], blue[1]});
                    }
                }
            }
        }
        System.out.println(-1);
    }

    // 이동 후 좌표를 반환, O로 들어갈 경우 -1, -1을 반환.
    // 이동 방향의 끝에서 더 가까운 공부터 움직여야 함.
    private static int[] move(int y, int x, int dir) {
        while (true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (map[ny][nx] != '.') {
                if (map[ny][nx] == 'O') return new int[]{-1, -1};
                else return new int[]{y, x};
            }
            y = ny;
            x = nx;
        }
    }
}
