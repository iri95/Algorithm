package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2186_문자판 {
    static int N, M, K, len, answer;
    static String str;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {-1, 1, 0, 0};
    static char[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        str = br.readLine();
        len = str.length();
        dp = new int[N][M][len + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (map[i][j] == str.charAt(0)) {
                    answer += dfs(i, j, 1);
                }
            }
        }
        System.out.println(answer);

    }
    static int dfs(int y, int x, int index){
        if (index == len) return 1;
        dp[y][x][index - 1] = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= K; j++) {
                int ny = y + dy[i] * j;
                int nx = x + dx[i] * j;
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || dp[ny][nx][index] == 0) continue;
                if (map[ny][nx] != str.charAt(index)){
                    dp[ny][nx][index] = 0;
                    continue;
                }
                if (dp[ny][nx][index] == -1) dp[ny][nx][index] = dfs(ny, nx, index + 1);
                dp[y][x][index - 1] += dp[ny][nx][index];
            }
        }

        return dp[y][x][index - 1];
    }
}
