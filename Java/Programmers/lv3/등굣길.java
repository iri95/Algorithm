package lv3;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        boolean[][] map = new boolean[n][m];
        for(int i = 0; i < puddles.length; i++)
            map[puddles[i][1] - 1][puddles[i][0] - 1] = true;

        int[][] dp = new int[n][m];
        for(int i = 0; i < m; i++){
            if(map[0][i]) break;
            dp[0][i] = 1;
        }
        for(int i = 0; i < n; i++){
            if(map[i][0]) break;
            dp[i][0] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(map[i][j]) continue;
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007;
            }
        }

        return dp[n-1][m-1];
    }
}