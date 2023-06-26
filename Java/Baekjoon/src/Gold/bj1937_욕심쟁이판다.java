package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://steady-coding.tistory.com/39
public class bj1937_욕심쟁이판다 {
    static int N, ans;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        System.out.println(ans);

    }

    static int dfs(int y, int x) {
        if(dp[y][x] != 0) return dp[y][x];

        dp[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
            if (map[y][x] < map[ny][nx]) {
                dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
            }

        }
        return dp[y][x];
    }

}
