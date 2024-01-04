package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj15990_123더하기5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int divide = 1000000009;
        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % divide;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % divide;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % divide;
        }
        for (int i = 0; i < T; i++) {
            int value = Integer.parseInt(br.readLine());
            sb.append((dp[value][1] + dp[value][2] + dp[value][3]) % divide).append("\n");
        }
        System.out.println(sb);
    }
}
