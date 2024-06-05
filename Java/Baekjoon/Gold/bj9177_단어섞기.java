package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO : DP를 Boolean 그래프로 구현함.
// https://www.acmicpc.net/source/28909250
public class bj9177_단어섞기 {
    static int len1, len2;
    static char[] str1, str2, strs;
    static boolean[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int t = 1; t <= N; t++) {
            st = new StringTokenizer(br.readLine());
            str1 = st.nextToken().toCharArray();
            str2 = st.nextToken().toCharArray();
            strs = st.nextToken().toCharArray();
            len1 = str1.length;
            len2 = str2.length;
            dp = new boolean[len1 + 1][len2 + 1];
            dfs(0, 0);
            if (dp[len1][len2]) ans.append("Data set ").append(t).append(": yes");
            else ans.append("Data set ").append(t).append(": no");
            ans.append("\n");
        }
        System.out.println(ans);
    }

    static void dfs(int y, int x) {
        dp[y][x] = true;
        int ny = y + 1;
        int nx = x + 1;
        if (ny <= len1 && str1[y] == strs[x + y] && !dp[ny][x]) dfs(ny, x);
        if (nx <= len2 && str2[x] == strs[x + y] && !dp[y][nx]) dfs(y, nx);
    }
}
