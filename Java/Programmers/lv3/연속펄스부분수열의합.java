package lv3;

public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        int N = sequence.length;
        long[][] dp = new long[N][2];
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        long answer = Math.max(dp[0][0], dp[0][1]);
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(0, dp[i - 1][1]) + sequence[i];
            dp[i][1] = Math.max(0, dp[i - 1][0]) - sequence[i];
            answer = Math.max(Math.max(dp[i][0], dp[i][1]), answer);
        }

        return answer;
    }
}
