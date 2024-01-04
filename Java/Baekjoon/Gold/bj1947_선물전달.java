package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1947_선물전달 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = ((dp[i - 1] * (i - 1)) % 1000000000 + (dp[i - 2] * (i - 1)) % 1000000000) % 1000000000;
        }
        System.out.println(dp[N]);
    }
}
