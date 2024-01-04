package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1513_경로찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        long[][][][] dp = new long[N + 1][M + 1][C + 1][C + 1]; // y, x, 번호, 갯수
        dp[1][1][0][0] = 1;

        for (int i = 1; i <= C; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = i;
            if (y == 1 && x == 1) {
                dp[1][1][i][1] = 1;
                dp[1][1][0][0] = 0;
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] > 0) {
                    for (int k = 0; k <= map[i][j]; k++) {
                        for (int l = 0; l < map[i][j]; l++) {
                            dp[i][j][map[i][j]][l + 1] += dp[i - 1][j][k][l]% 1000007 + dp[i][j-1][k][l]% 1000007;
                        }
                    }
                } else {
                    for (int k = 0; k <= C; k++) {
                        for (int l = 0; l <= C; l++) {
                            dp[i][j][k][l] += dp[i - 1][j][k][l]% 1000007 + dp[i][j - 1][k][l]% 1000007;
                        }
                    }
                }
            }
        }
        for (int i = 0; i <= C; i++) {
            int result = 0;
            for (int j = 0; j <= C; j++) {
                result += dp[N][M][j][i];
            }
            System.out.print(result % 1000007 + " ");
        }

    }
}
