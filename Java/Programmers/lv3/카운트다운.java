package lv3;

public class 카운트다운 {
    static int INF = 100_001;
    static int[][] dp;

    public int[] solution(int target) {
        dp = new int[target + 1][2];
        for (int i = 0; i < target; i++)
            dp[i][0] = INF;

        return sol(0, target);
    }

    private static int[] sol(int score, int target) {
        if (dp[score][0] != INF)
            return dp[score];

        int[] s;
        if (score + 50 <= target) {
            s = sol(score + 50, target);
            if (dp[score][0] > s[0] + 1 ||
                    (dp[score][0] == s[0] + 1 && dp[score][1] < s[1] + 1)) {
                dp[score][0] = s[0] + 1;
                dp[score][1] = s[1] + 1;
            }
        }

        for (int i = 1; i <= 20; i++) {
            if (score + i <= target) {
                s = sol(score + i, target);
                if (dp[score][0] > s[0] + 1 ||
                        (dp[score][0] == s[0] + 1 && dp[score][1] < s[1] + 1)) {
                    dp[score][0] = s[0] + 1;
                    dp[score][1] = s[1] + 1;
                }
            }

            if (score + (i * 2) <= target) {
                s = sol(score + (i * 2), target);
                if (dp[score][0] > s[0] + 1 ||
                        (dp[score][0] == s[0] + 1 && dp[score][1] < s[1])) {
                    dp[score][0] = s[0] + 1;
                    dp[score][1] = s[1];
                }
            }

            if (score + (i * 3) <= target) {
                s = sol(score + (i * 3), target);
                if (dp[score][0] > s[0] + 1 ||
                        (dp[score][0] == s[0] + 1 && dp[score][1] < s[1])) {
                    dp[score][0] = s[0] + 1;
                    dp[score][1] = s[1];
                }
            }
        }
        return dp[score];
    }
}
