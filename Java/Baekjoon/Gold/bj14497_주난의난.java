package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class bj14497_주난의난 {
    static int N, M, x1, y1, x2, y2;
    static int[] dy = {0, 0, -1, 1}, dx = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        st = new StringTokenizer(br.readLine());
        y1 = Integer.parseInt(st.nextToken());
        x1 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++)
                map[i][j] = str.charAt(j - 1);
        }
        bfs();
    }

    private static void bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x1, y1, 0});
        visited[y1][x1] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == x2 && cur[1] == y2) {
                System.out.println(cur[2]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur[1] + dy[i];
                int nx = cur[0] + dx[i];
                if (ny <= 0 || ny > N || nx <= 0 || nx > M || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                if (map[ny][nx] == '0') q.addFirst(new int[]{nx, ny, cur[2]});
                else q.addLast(new int[]{nx, ny, cur[2] + 1});
            }
        }
    }
}
