package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2602_돌다리건너기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String devil = br.readLine();
        String angel = br.readLine();
        int len = devil.length();
        char[][] bridge = new char[2][len];
        bridge[0] = devil.toCharArray();
        bridge[1] = angel.toCharArray();
        int[][][] dp = new int[str.length()][2][len + 1];
        char c = str.charAt(0);
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= len; j++) {
                if (bridge[i][j - 1] == c) dp[0][i][j] = dp[0][i][j - 1] + 1;
                else dp[0][i][j] = dp[0][i][j - 1];
            }
        }
        for (int i = 1; i < str.length(); i++) {
            c = str.charAt(i);
            for (int j = 0; j < 2; j++) { // (j + 1) % 2
                for (int k = 1; k <= len; k++) {
                    if (bridge[j][k - 1] == c) dp[i][j][k] = dp[i-1][(j + 1) % 2][k - 1] + dp[i][j][k - 1];
                    else dp[i][j][k] = dp[i][j][k - 1];
                }
            }
        }
        System.out.println(dp[str.length()-1][0][len] + dp[str.length()-1][1][len]);
    }
}
