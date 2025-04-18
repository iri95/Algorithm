package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1720_타일코드 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2] * 2;

        if (N % 2 == 1) System.out.println((dp[N] + dp[N / 2]) / 2);
        else System.out.println((dp[N / 2 - 1] * 2 + dp[N / 2] + dp[N]) / 2);
    }
}
