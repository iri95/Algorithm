package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17090_미로탈출하기 {
    static int N, M, ans;
    static char[][] map;
    static int[][] cnt;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        cnt = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) if (!visited[i][j]) dfs(i, j);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) ans += cnt[i][j];

        System.out.println(ans);
    }

    private static int dfs(int y, int x) {
        visited[y][x] = true;
        int ny = y, nx = x;
        if (map[y][x] == 'U') ny--;
        else if (map[y][x] == 'R') nx++;
        else if (map[y][x] == 'D') ny++;
        else nx--;
        if (ny < 0 || ny == N || nx < 0 || nx >= M) return cnt[y][x] = 1;
        if (visited[ny][nx]) return cnt[y][x] = cnt[ny][nx];
        cnt[y][x] = dfs(ny, nx);
        return cnt[y][x];
    }
}
