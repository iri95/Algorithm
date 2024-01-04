package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2096_내려가기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][3];
        int[][][] dp = new int[N + 1][3][2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]) + map[i][0];
            dp[i][1][0] = Math.max(dp[i-1][2][0],Math.max(dp[i - 1][0][0], dp[i - 1][1][0]))+ map[i][1];
            dp[i][2][0] = Math.max(dp[i - 1][1][0], dp[i - 1][2][0]) + map[i][2];
            dp[i][0][1] = Math.min(dp[i - 1][0][1], dp[i - 1][1][1])+ map[i][0];
            dp[i][1][1] = Math.min(dp[i-1][2][1],Math.min(dp[i - 1][0][1], dp[i - 1][1][1]))+ map[i][1];
            dp[i][2][1] = Math.min(dp[i - 1][1][1], dp[i - 1][2][1])+ map[i][2];
        }
        System.out.println(Math.max(dp[N][2][0],Math.max(dp[N][0][0], dp[N][1][0])) + " " + Math.min(dp[N][2][1],Math.min(dp[N][0][1], dp[N][1][1])));
    }
}
