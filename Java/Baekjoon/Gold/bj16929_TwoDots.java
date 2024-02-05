package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16929_TwoDots {
    static int N, M, sy, sx;
    static char sc;
    static boolean result = false;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            if (result) break;
            for (int j = 0; j < M; j++) {
                sy = i;
                sx = j;
                sc = map[i][j];
                visit[i][j] = true;
                dfs(sy, sx, 1);
                visit[i][j] = false;
                if (result) break;
            }
        }
        if (result) System.out.println("Yes");
        else System.out.println("No");
    }

    static void dfs(int y, int x, int cnt) {
        if (result) return;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny == sy && nx == sx && cnt + 1 >= 4) {
                result = true;
                return;
            }
            if (ny < 0 || ny >= N || nx < 0 || nx >= M || visit[ny][nx]) continue;
            if (map[ny][nx] == sc){
                visit[ny][nx] = true;
                dfs(ny, nx, cnt + 1);
                visit[ny][nx] = false;
            }

        }
    }
}
