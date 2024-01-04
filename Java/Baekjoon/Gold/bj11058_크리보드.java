package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj11058_크리보드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        for (int i = 1; i <= 6; i++) {
            dp[i] = i;
        }
        for (int i = 7; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 3] * 2, Math.max(dp[i - 4] * 3, dp[i-5] * 4));
        }
        System.out.println(dp[N]);
    }
}
