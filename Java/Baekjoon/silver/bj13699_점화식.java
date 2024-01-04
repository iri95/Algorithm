package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj13699_점화식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[36];
        dp[0] = 1;
        for (int i = 1; i < 36; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < i / 2; j++) {
                    dp[i] += dp[i - j - 1] * dp[j] * 2;
                }
            } else {
                for (int j = 0; j < i / 2; j++) {
                    dp[i] += dp[i - j - 1] * dp[j] * 2;
                }
                dp[i] += dp[i / 2] * dp[i / 2];
            }
        }
        System.out.println(dp[N]);
    }
}
