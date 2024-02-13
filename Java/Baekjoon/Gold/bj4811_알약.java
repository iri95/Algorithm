package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj4811_알약 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[61][31];
        dp[1][1] = 1;
        for (int i = 2; i < 61; i++) {
            for (int j = 0; j < 31; j++) {
                if (j == 0) dp[i][0] += dp[i - 1][1];
                else if (j == 30) dp[i][j] += dp[i - 1][29];
                else dp[i][j] += dp[i - 1][j - 1] + dp[i - 1][j + 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            sb.append(dp[2 * N][0]).append("\n");
        }
        System.out.println(sb);
    }
}
