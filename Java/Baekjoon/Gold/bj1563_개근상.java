package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1563_개근상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int divide = 1000_000;
        int[][][] dp = new int[1001][2][3];
        dp[1][0][0] = 1; // O -> 뒤에 O를 붙이는 경우
        dp[1][1][0] = 1; // L
        dp[1][0][1] = 1; // A

        dp[2][0][0] = 2; // OO, AO
        dp[2][1][0] = 3; // OL, AL, LO
        dp[2][1][1] = 1; // LA
        dp[2][0][1] = 1; // OA
        dp[2][0][2] = 1; // AA

        dp[3][0][0] = dp[2][0][0] + dp[2][0][1] + dp[2][0][2];
        dp[3][1][0] = dp[2][0][0] + dp[2][0][1] + dp[2][0][2] + dp[2][1][0] + dp[2][1][1] + dp[2][1][2];
        dp[3][0][1] = dp[2][0][0];
        dp[3][1][1] = dp[2][1][0];
        dp[3][0][2] = dp[2][0][1];
        dp[3][1][2] = 1; // LAA, dp[2][1][1];
        for (int i = 4; i <= N; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % divide;
            dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % divide;
            dp[i][0][1] = dp[i - 1][0][0] % divide;
            dp[i][1][1] = dp[i - 1][1][0] % divide;
            dp[i][0][2] = dp[i - 1][0][1] % divide;
            dp[i][1][2] = dp[i - 1][1][1] % divide;
        }
        int result = (dp[N][0][0] + dp[N][1][0] + dp[N][0][1] + dp[N][1][1] + dp[N][0][2] + dp[N][1][2]) % divide;
        System.out.println(result);

    }
}
