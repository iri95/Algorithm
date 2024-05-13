package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2691_숫자카드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (str.charAt(i - 1) - '0' != 0) dp[i] += dp[i - 1];
            int k = Integer.parseInt(str.substring(i - 2, i));
            if (k < 35 && k > 9) dp[i] += dp[i - 2];
        }
        System.out.println(dp[N]);
    }
}
