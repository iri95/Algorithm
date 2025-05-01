package lv3;

public class 산모양타일링 {
    public int solution(int n, int[] tops) {
        int div = 10_007;
        int[] dp = new int[4];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int all = dp[0] + dp[1] + dp[2] + dp[3];

            dp[1] = (all - dp[2]) % div;
            dp[0] = dp[2] = all % div;
            dp[3] = all * tops[i - 1] % div;
        }

        int answer = 0;
        for (int x : dp)
            answer = (answer + x) % div;

        return answer;
    }
}
