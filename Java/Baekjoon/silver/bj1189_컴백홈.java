package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1189_컴백홈 {
    static int R, C, K, ans;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static boolean[][] visited;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int y, int x, int cnt) {
        if (y == 0 && x == C - 1) {
            if (cnt == K) ans++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == 'T' || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            dfs(ny, nx, cnt + 1);
            visited[ny][nx] = false;
        }
    }
}
