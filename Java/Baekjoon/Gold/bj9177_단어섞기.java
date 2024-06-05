package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// TODO : DP를 Boolean 그래프로 구현함.
// https://velog.io/@embeddedjune/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-DP-9177-%EB%8B%A8%EC%96%B4-%EC%84%9E%EA%B8%B0
public class bj9177_단어섞기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[] str1, str2, strs;
        boolean[][] dp;
        for (int t = 1; t <= N; t++) {
            st = new StringTokenizer(br.readLine());
            str1 = st.nextToken().toCharArray();
            str2 = st.nextToken().toCharArray();
            strs = st.nextToken().toCharArray();
            int len1 = str1.length;
            int len2 = str2.length;
            dp = new boolean[len1 + 1][len2 + 1];
            dp[0][0] = true;
            for (int i = 1; i <= len1; i++) dp[i][0] = str1[i - 1] == strs[i - 1] && dp[i - 1][0];
            for (int i = 1; i <= len2; i++) dp[0][i] = str2[i - 1] == strs[i - 1] && dp[0][i - 1];
            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    char a = str1[i - 1];
                    char b = str2[j - 1];
                    char c = strs[i + j - 1];
                    if(a != c && b != c) dp[i][j] = false;
                    else if(a == c && b != c) dp[i][j] = dp[i - 1][j];
                    else if(a != c) dp[i][j] = dp[i][j - 1];
                    else dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
            if (dp[len1][len2])ans.append("Data set " + t + ": yes" );
            else ans.append("Data set " + t + ": no");
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
