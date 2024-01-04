package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2133_타일채우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[31];
        dp[2] = 3;
        dp[4] = dp[2] * 3 + 2;
        int sum = 1;
        for (int i = 6; i < 31; i = i + 2) {
            dp[i] = dp[i-2] * 3 + dp[i-4] * 2 + sum * 2;
            sum += dp[i-4];
        }
        System.out.println(dp[N]);
    }
}
