package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14923_미로탈출 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];
        st = new StringTokenizer(br.readLine());
        int Hy = Integer.parseInt(st.nextToken()) - 1;
        int Hx = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        int Ey = Integer.parseInt(st.nextToken()) - 1;
        int Ex = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        visited[Hy][Hx][0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{Hy, Hx, 0}); // 0 -> 벽을 부수지 않은 상태
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while (size-- > 0) {
                int[] p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx][p[2]]) continue;

                    if (map[ny][nx] == 1) {
                        if (p[2] == 1) continue;
                        else {
                            visited[ny][nx][1] = true;
                            q.add(new int[]{ny, nx, 1});
                        }
                    } else {
                        visited[ny][nx][p[2]] = true;
                        q.add(new int[]{ny, nx, p[2]});
                    }
                    if (ny == Ey && nx == Ex) {
                        System.out.println(cnt);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
