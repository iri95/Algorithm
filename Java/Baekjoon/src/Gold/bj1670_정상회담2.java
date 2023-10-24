package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1670_정상회담2 {
    public static void main(String[] args) throws Exception {
        long[] dp = new long[5001];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 5001; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
                dp[i] = dp[i] % 987654321;
            }

        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n / 2]);
    }
}
