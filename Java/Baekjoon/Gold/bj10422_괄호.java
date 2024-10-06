package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj10422_괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long INF = 1_000_000_007;
        long[] dp = new long[5_001];
        dp[0] = dp[2] = 1;
        for (int i = 4; i <= 5000; i += 2) {
            for (int j = 0; j < i; j += 2) {
                dp[i] += dp[j] * dp[i - 2 - j];
                dp[i] %= INF;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++)
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        System.out.println(sb);
    }
}
