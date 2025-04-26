package lv3;

import java.util.*;

public class 최적의행렬곱셈 {
    static int INF = Integer.MAX_VALUE;
    static int[][] dp;

    public int solution(int[][] matrix_sizes) {
        int len = matrix_sizes.length;
        dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        for (int i = 0; i < len - 1; i++)
            dp[i][i + 1] = matrix_sizes[i][0] * matrix_sizes[i][1] * matrix_sizes[i + 1][1];

        return sol(0, len - 1, matrix_sizes);
    }

    private static int sol(int l, int r, int[][] matrix) {
        if (dp[l][r] != INF) return dp[l][r];

        for (int i = l; i < r; i++) {
            int left = sol(l, i, matrix);
            int right = sol(i + 1, r, matrix);
            dp[l][r] = Math.min(dp[l][r], matrix[l][0] * matrix[i][1] * matrix[r][1] + left + right);
        }

        return dp[l][r];
    }
}
