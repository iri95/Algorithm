package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1562_계단수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][][] dp = new long[n + 1][10][1024];
        for (int i = 0; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }
        int k = 1_000_000_000;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 1024; j++) {
                dp[i][0][1 | j] += dp[i - 1][1][j] % k;
            }
            for (int j = 1; j < 9; j++) {
                for (int l = 0; l < 1024; l++) {
                    dp[i][j][1 << j | l] += dp[i - 1][j - 1][l] % k + dp[i - 1][j + 1][l] % k;
                }
            }
            for (int j = 0; j < 1024; j++) {
                dp[i][9][1 << 9 | j] += dp[i - 1][8][j] % k;
            }
        }
        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += dp[n][i][1023];
        }
        result %= k;
        System.out.println(result);
    }
}
