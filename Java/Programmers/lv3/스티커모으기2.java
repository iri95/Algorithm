package lv3;

public class 스티커모으기2 {
    public static int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        if (n == 1) return sticker[0];
        else if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        int[][] dp = new int[n][2];
        dp[0][0] = sticker[0];
        dp[1][0] = sticker[0];
        dp[1][1] = sticker[1];
        for (int i = 2; i < n; i++) {
            if (i != n - 1) dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + sticker[i]);
            dp[i][1] = Math.max(dp[i - 1][1], sticker[i] + dp[i - 2][1]);
        }
        answer = Math.max(dp[n - 2][0], dp[n - 1][1]);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}));
    }
}
