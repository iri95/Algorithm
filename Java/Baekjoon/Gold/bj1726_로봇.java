package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1726_로봇 {
    static int M, N;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;
    static int[][][] result;
    static boolean[][][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        result = new int[M][N][4];
        visit = new boolean[M][N][4];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        visit[i][j][k] = true;
                    }
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] start = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        st = new StringTokenizer(br.readLine());
        int[] end = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        visit[start[0]][start[1]][start[2]] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            while (size-- > 0) {
                int[] p = queue.poll();
                int nd1 = p[2] / 2 == 0 ? 2 : 0;
                int nd2 = p[2] / 2 == 0 ? 3 : 1;
                if (!visit[p[0]][p[1]][nd1]) {
                    visit[p[0]][p[1]][nd1] = true;
                    queue.add(new int[]{p[0], p[1], nd1});
                    result[p[0]][p[1]][nd1] = cnt;
                }
                if (!visit[p[0]][p[1]][nd2]) {
                    visit[p[0]][p[1]][nd2] = true;
                    queue.add(new int[]{p[0], p[1], nd2});
                    result[p[0]][p[1]][nd2] = cnt;
                }
                for (int i = 1; i <= 3; i++) {
                    int ny = p[0] + dy[p[2]] * i;
                    int nx = p[1] + dx[p[2]] * i;
                    if (ny < 0 || ny >= M || nx < 0 || nx >= N || map[ny][nx] == 1) break;
                    if (visit[ny][nx][p[2]]) continue;
                    visit[ny][nx][p[2]] = true;
                    queue.add(new int[]{ny, nx, p[2]});
                    result[ny][nx][p[2]] = cnt;
                }
                if (visit[end[0]][end[1]][end[2]]) break;
            }
            if (visit[end[0]][end[1]][end[2]]) break;
        }
        System.out.println(result[end[0]][end[1]][end[2]]);
    }
}
