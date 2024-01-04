package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1103_게임 {
    static int N, M;
    static boolean roof = false;
    static char[][] map;
    static int[][] result;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        result = new int[N][M];
        visit = new boolean[N][M];
        visit[0][0] = true;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0);
        if (roof) {
            System.out.println(-1);
            return;
        }
        System.out.println(result[0][0]);
    }

    static int dfs(int y, int x) {
        int next = Character.getNumericValue(map[y][x]);
        boolean po = false;
        for (int i = 0; i < 4; i++) {
            int ny = y + next * dy[i];
            int nx = x + next * dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 'H') continue;
            if (visit[ny][nx]) {
                roof = true;
                return 0;
            }
            po = true;
            if (result[ny][nx] != 0) {
                result[y][x] = Math.max(result[y][x], result[ny][nx] + 1);
                continue;
            }
            visit[ny][nx] = true;
            result[y][x] = Math.max(result[y][x], dfs(ny, nx) + 1);
            visit[ny][nx] = false;
        }
        if (!po) {
            result[y][x] = 1;
        }
        return result[y][x];

    }
}
