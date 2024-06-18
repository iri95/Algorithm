package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj21609_상어중학교 {
    static int N, M, answer;
    static boolean end;
    static int[] point;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (!end) {
            end = true;
            point = new int[4]; // y, x, 갯수, 무지개 개수;
            autoPlay();
        }
        System.out.println(answer);

    }

    static void autoPlay() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[y][x] <= 0) continue;
                if (bfs(y, x, map[y][x])) end = false;
            }
        }
        if (end) return;
        answer += point[2] * point[2];
        remove();
        gravity();
        rotation();
        gravity();
    }

    static boolean bfs(int y, int x, int block) {
        int count = 1;
        int rainbow = 0;
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> points = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        q.add(new int[]{y, x});
        points.add(new int[]{y, x});
        visited[y][x] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;
                if (map[ny][nx] == block || map[ny][nx] == 0) {
                    if (map[ny][nx] == 0) rainbow++;
                    else {
                        y = Math.min(y, ny);
                        x = Math.min(x, nx);
                    }
                    visited[ny][nx] = true;
                    count++;
                    points.add(new int[]{ny, nx});
                    q.add(new int[]{ny, nx});
                }
            }
        }
        if (count < 2) return false;

        if (point[2] < count) {
            point = new int[]{y, x, count, rainbow};
            list = points;
        } else if (point[2] == count) {
            if (point[3] < rainbow) {
                point = new int[]{y, x, count, rainbow};
                list = points;
            } else if (point[3] == rainbow) {
                if (point[0] < y) {
                    point = new int[]{y, x, count, rainbow};
                    list = points;
                } else if (point[0] == y) {
                    if (point[1] < x) {
                        point = new int[]{y, x, count, rainbow};
                        list = points;
                    }
                }
            }
        }
        return true;
    }

    static void remove() {
        for (int[] p : list) {
            map[p[0]][p[1]] = -2;
        }
    }

    static void gravity() {
        for (int i = N - 1; i > 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (map[i][j] == -2) {
                    int y = i - 1;
                    while (y >= 0) {
                        if (map[y][j] == -1) break;
                        if (map[y][j] != -2) {
                            map[i][j] = map[y][j];
                            map[y][j] = -2;
                            break;
                        }
                        y--;
                    }
                }
            }
        }
    }

    static void rotation() {
        int[][] subMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                subMap[i][j] = map[j][N - i - 1];
            }
        }
        map = subMap;
    }

}
