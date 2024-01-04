package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj17404_RGB거리2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] home = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];
        int[] result = new int[3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            home[i][0] = Integer.parseInt(st.nextToken());
            home[i][1] = Integer.parseInt(st.nextToken());
            home[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[1][i] = home[1][i];
                } else {
                    dp[1][j] = 1001;
                }
            }
            for (int j = 2; j <= N; j++) {
                dp[j][0] = home[j][0] + Integer.min(dp[j - 1][1], dp[j - 1][2]);
                dp[j][1] = home[j][1] + Integer.min(dp[j - 1][0], dp[j - 1][2]);
                dp[j][2] = home[j][2] + Integer.min(dp[j - 1][1], dp[j - 1][0]);
                if (j == N) {
                    if (i == 0) {
                        result[0] = Integer.min(dp[N][1], dp[N][2]);
                    } else if (i == 1) {
                        result[1] = Integer.min(dp[N][0], dp[N][2]);
                    } else {
                        result[2] = Integer.min(dp[N][1], dp[N][0]);
                    }
                }
            }
        }
        System.out.println(Integer.min(result[0], Integer.min(result[1], result[2])));
    }
}
