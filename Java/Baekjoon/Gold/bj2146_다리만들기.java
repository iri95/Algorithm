package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2146_다리만들기 {
    static int N, min = Integer.MAX_VALUE;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[N][N];
        int number = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] > 0) {
                    check(i, j, number);
                    number++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0 )bridge(i, j, map[i][j]);
            }
        }
        System.out.println(min);
    }

    // 섬마다 번호를 매기는 함수
    static void check(int y, int x, int number) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        map[y][x] = number;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || visit[ny][nx] || map[ny][nx] == 0) continue;
                map[ny][nx] = number;
                visit[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
    }

    // 섬의 끝점에서 다리를 잇는 함수
    static void bridge(int y, int x, int number) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        boolean[][] visited = new boolean[N][N];
        visited[y][x] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || map[ny][nx] == number) continue;
                    if (visit[ny][nx]) {
                        min = Math.min(min, cnt);
                        visited[ny][nx] = true;
                    }else{
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
            cnt++;
        }
    }
}
