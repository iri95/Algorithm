package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj20058_마법사상어와파이어스톰 {
    static int N, sum = 0, max = 0;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, N);
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(st.nextToken());
            q = (int) Math.pow(2, q);
            for (int j = 0; j < N; j += q) {
                for (int k = 0; k < N; k += q) {
                    spin(q, j, k);
                }
            }
            fire();
        }

        max();
        System.out.println(sum);
        System.out.println(max);
    }

    private static void spin(int n, int y, int x) {
        int[][] temp = new int[n][n];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++)
                temp[j - x][n - i + y - 1] = map[i][j];
        }
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++)
                map[i][j] = temp[i - y][j - x];
        }
    }

    private static void fire() {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == 0) continue;
                    cnt++;
                }
                if (cnt < 3) list.add(new int[] {i, j});
            }
        }
        for (int[] p : list) map[p[0]][p[1]]--;
    }

    private static void max(){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || map[i][j] == 0) continue;
                visited[i][j] = true;
                sum += map[i][j];
                q.add(new int[]{i, j});
                int cnt = 1;
                while (!q.isEmpty()) {
                    int[] p = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int ny = p[0] + dy[k];
                        int nx = p[1] + dx[k];
                        if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || map[ny][nx] == 0) continue;
                        visited[ny][nx] = true;
                        cnt++;
                        q.add(new int[]{ny, nx});
                        sum += map[ny][nx];
                    }
                }
                max = Math.max(cnt, max);
            }
        }
    }
}
