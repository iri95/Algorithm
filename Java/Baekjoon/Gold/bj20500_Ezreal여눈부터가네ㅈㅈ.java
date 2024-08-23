package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj20500_Ezreal여눈부터가네ㅈㅈ {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int div = 1_000_000_007;
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][15];
        dp[1][1] = dp[1][5] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 14; j++) {
                int temp = j * 10 + 1;
                temp %= 15;
                dp[i][temp] += dp[i - 1][j];
                dp[i][temp] %= div;

                temp = j * 10 + 5;
                temp %= 15;
                dp[i][temp] += dp[i - 1][j];
                dp[i][temp] %= div;
            }
        }

        System.out.println(dp[n][0]);
    }
}

