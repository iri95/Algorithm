package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj21611_마법사상어와블리자드 {
    static int N, M, sy, sx, answer = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sx = sy = (N + 1) / 2;
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            destroy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            while (explosion()){}
        }
        System.out.println(answer);
    }

    private static void destroy(int d, int s) {
        if (d == 1) d = 3;
        else if (d == 2) d = 1;
        else if (d == 3) d = 0;
        else d = 2;
        int ny = sy;
        int nx = sx;
        while (s-- > 0) {
            ny += dy[d];
            nx += dx[d];
            if (ny > N || ny <= 0 || nx > N || nx <= 0) break;
            map[ny][nx] = 0;
        }
        pull();
    }

    private static boolean explosion() {
        int ny = sy;
        int nx = sx;
        int pre = 0;
        int d = -1;
        int count = 0;
        boolean ex = false;
        Queue<int[]> q = new ArrayDeque<>();
        while (true) {
            count++;
            for (int i = 0; i < 2; i++) {
                d = (d + 1) % 4;
                for (int j = 0; j < count; j++) {
                    ny += dy[d];
                    nx += dx[d];
                    if (nx <= 0 || map[ny][nx] != pre) {
                        if (q.size() >= 4) {
                            ex = true;
                            answer += pre * q.size();
                            while (!q.isEmpty()) {
                                int[] delete = q.poll();
                                map[delete[0]][delete[1]] = 0;
                            }
                        } else q.clear();
                    }
                    if (nx <= 0 || map[ny][nx] == 0) {
                        if (ex) pull();
                        else change();
                        return ex;
                    }
                    pre = map[ny][nx];
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }

    private static void pull() {
        int ny = sy;
        int nx = sx;
        int d = -1;
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        while (true) {
            count++;
            for (int i = 0; i < 2; i++) {
                d = (d + 1) % 4;
                for (int j = 0; j < count; j++) {
                    ny += dy[d];
                    nx += dx[d];
                    if (nx <= 0) return;
                    if (map[ny][nx] == 0) q.add(new int[]{ny, nx});
                    else if (!q.isEmpty()) {
                        int[] move = q.poll();
                        map[move[0]][move[1]] = map[ny][nx];
                        map[ny][nx] = 0;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    private static void change() {
        int ny = sy;
        int nx = sx;
        int d = -1;
        int count = 0;
        int pre = 0;
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        first:
        while (true) {
            count++;
            for (int i = 0; i < 2; i++) {
                d = (d + 1) % 4;
                for (int j = 0; j < count; j++) {
                    ny += dy[d];
                    nx += dx[d];
                    if (pre == map[ny][nx]) cnt++;
                    else {
                        if (pre != 0) {
                            q.add(cnt);
                            q.add(pre);
                        }
                        cnt = 1;
                    }
                    if (nx <= 0 || map[ny][nx] == 0) break first;
                    pre = map[ny][nx];
                }
            }
        }
        count = 0;
        ny = sy;
        nx = sx;
        d = -1;
        while (!q.isEmpty()) {
            count++;
            for (int i = 0; i < 2; i++) {
                d = (d + 1) % 4;
                for (int j = 0; j < count; j++) {
                    ny += dy[d];
                    nx += dx[d];
                    if (nx <= 0) return;
                    if (!q.isEmpty()) map[ny][nx] = q.poll();
                    else map[ny][nx] = 0;
                }
            }
        }
    }
}
