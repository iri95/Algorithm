package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17485_진우의달여행Large {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M];
        int[][][] dp = new int[N + 1][M][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 100001;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    dp[i][0][0] = Math.min(dp[i-1][1][2],dp[i-1][1][1]) + map[i][0];
                    dp[i][0][1] = dp[i-1][0][0] + map[i][0];
                    dp[i][0][2] = max;
                } else if (j == M - 1) {
                    dp[i][M-1][0] = max;
                    dp[i][M-1][1] = dp[i-1][M-1][2] + map[i][M-1];
                    dp[i][M-1][2] = Math.min(dp[i-1][M-2][1], dp[i-1][M-2][0]) + map[i][M-1];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + map[i][j];
                }
            }

        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(dp[N][i][j], min);
            }

        }
        System.out.println(min);
    }
}
