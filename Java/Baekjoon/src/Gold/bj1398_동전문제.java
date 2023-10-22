package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1398_동전문제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[100];
        dp[0] = 0;
        for (int i = 1; i < 10; i++) dp[i] = dp[i - 1] + 1;
        for (int i = 10; i < 25; i++) dp[i] = Math.min(dp[i - 1], dp[i - 10]) + 1;
        for (int i = 25; i < 100; i++) dp[i] = Math.min(dp[i - 1], Math.min(dp[i - 10], dp[i - 25])) + 1;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int ans = 0;
            long P = Long.parseLong(br.readLine());
            for (int i = 0; i < 8; i++) {
                ans += dp[(int) (P % 100)];
                P /= 100;
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
