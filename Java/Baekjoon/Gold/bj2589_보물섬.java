package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2589_보물섬 {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] map, visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String LW = br.readLine();
            for (int j = 0; j < M; j++) {
                if (LW.charAt(j) == 'L') {
                    map[i][j] = true;
                }
            }
        }
        int result = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!map[i][j]) continue;
                int cnt = 0;
                visit = new boolean[N][M];
                queue.offer(new int[]{i, j});
                visit[i][j] = true;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    cnt++;
                    while (size-- > 0) {
                        int[] p = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int ny = p[0] + dy[k];
                            int nx = p[1] + dx[k];
                            if (ny >= N || nx >= M || ny < 0 || nx < 0 || visit[ny][nx] || !map[ny][nx]) continue;
                            result = Math.max(cnt, result);
                            visit[ny][nx] = true;
                            queue.offer(new int[]{ny, nx});
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}


