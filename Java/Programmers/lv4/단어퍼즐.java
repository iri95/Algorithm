package lv4;

public class 단어퍼즐 {
    static int[] dp;

    public int solution(String[] strs, String t) {
        dp = new int[t.length()];

        sol(t, 0, t.length(), strs);

        return dp[0] == 200_001 ? -1 : dp[0];
    }

    private static int sol(String t, int strIdx, int len, String[] strs) {
        if (strIdx >= len) return 0;
        if (dp[strIdx] != 0) return dp[strIdx];
        int min = 200_001;
        for (String str : strs) {
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                if (strIdx + j >= len || t.charAt(strIdx + j) != str.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                min = Math.min(min, sol(t, strIdx + str.length(), len, strs) + 1);
            }
        }
        return dp[strIdx] = min;
    }
}
