package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1245_농장관리 {
    static int N, M;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visit[i][j])continue;
                if (check(i, j)) cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean check(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> queue2 = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        queue2.offer(new int[]{y, x});
        visit[y][x] = true;

        // 먼저 동일한 높이의 크기 모으기
        int max = map[y][x];
        boolean[][] inVisit = new boolean[N][M];
        inVisit[y][x] = true;
        while (!queue2.isEmpty()) {
            int[] p = queue2.poll();
            for (int i = 0; i < 8; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || inVisit[ny][nx]) continue;
                if (max == map[ny][nx]) {
                    queue.offer(new int[]{ny, nx});
                    queue2.offer(new int[]{ny, nx});
                    inVisit[ny][nx] = true;
                    visit[ny][nx] = true;
                }
            }
        }
        // 그 값을 bfs
        // 더 큰 값이 있으면 false
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || inVisit[ny][nx]) continue;
                if (map[ny][nx] > max) return false;
                inVisit[ny][nx] = true;
            }
        }
        // 더 큰 값이 없으면 true
        return true;
    }
}
