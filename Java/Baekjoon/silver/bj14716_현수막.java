package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14716_현수막 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dy = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] dx = {1, -1, 1, -1, 0, 1, -1, 0};

        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (st.nextToken().equals("0")) {
                    map[i][j] = true;
                }
            }
        }
        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!map[i][j]) {
                    cnt++;
                    queue.offer(new int[]{i, j});
                    map[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] p = queue.poll();
                        int y = p[0];
                        int x = p[1];
                        for (int k = 0; k < 8; k++) {
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx]) continue;
                            queue.offer(new int[]{ny, nx});
                            map[ny][nx] = true;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
