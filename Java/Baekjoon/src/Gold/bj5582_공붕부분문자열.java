package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj5582_공붕부분문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                max = Math.max(dp[i + 1][j + 1], max);
            }
        }
        System.out.println(max);
    }
}
