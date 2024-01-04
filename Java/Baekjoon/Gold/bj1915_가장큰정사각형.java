package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1915_가장큰정사각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String a = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = Character.getNumericValue(a.charAt(j-1));
            }
        }
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max * max);
    }
}
