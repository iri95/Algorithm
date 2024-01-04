package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9252_LCS2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int len1 = str1.length;
        int len2 = str2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j-1], Math.max(dp[i-1][j], dp[i-1][j-1] + 1));
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], Math.max(dp[i-1][j], dp[i - 1][j - 1]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int y = len1;
        int x = len2;
        while (y > 0 && x > 0) {
            if(dp[y][x] == dp[y-1][x]) {
                y--;
            }else if(dp[y][x] == dp[y][x-1]) {
                x--;
            }else {
                sb.append(str1[y - 1]);
                y--;
                x--;
            }
        }
        sb.reverse();
        System.out.println(dp[len1][len2]);
        System.out.println(sb);
    }
}
