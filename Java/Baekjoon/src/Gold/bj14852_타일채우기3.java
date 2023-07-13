package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj14852_타일채우기3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];
        if (N == 1) {
            System.out.println(2);
            return;
        } else if (N == 2) {
            System.out.println(7);
            return;
        }
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;
        dp[3] = 22;
        long sum = 1;
        for (int i = 4; i <= N; i++) {
            dp[i] = (2 * dp[i - 1] + 3 * dp[i - 2] + 2 * dp[i - 3] + 2 * sum) % 1000000007;
            sum = (sum + dp[i - 3]) % 1000000007;
        }
        System.out.println(dp[N] % 1000000007);


    }
}
