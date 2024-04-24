package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2169_로봇조종하기 {
    static int[] dy = {0, 0, 1};
    static int[] dx = {1, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        int[][] arrL = new int[N + 1][M + 1];
        int[][] arrR = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= M; i++) {
            dp[1][i] = dp[1][i - 1] + map[1][i];
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arrL[i][j] = dp[i - 1][j] + map[i][j];
                arrR[i][j] = dp[i - 1][j] + map[i][j];
            }
            for (int j = 2; j <= M; j++) {
                arrR[i][j] = Math.max(arrR[i][j - 1] + map[i][j], arrR[i][j]);
            }
            for (int j = M - 1; j > 0; j--) {
                arrL[i][j] = Math.max(arrL[i][j + 1] + map[i][j], arrL[i][j]);
            }
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(arrL[i][j], arrR[i][j]);
            }
        }
        System.out.println(dp[N][M]);

    }
}
