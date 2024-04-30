package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// https://www.acmicpc.net/source/66462648
public class bj1509_팰린드롬분할 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int N = chars.length;
        boolean[][] isPalindrome = new boolean[N][N];
        for (int i = 0; i < N; i++) isPalindrome[i][i] = true;
        for (int i = 1; i < N; i++) // 두 개가 같은 경우
            if (chars[i] == chars[i-1]) isPalindrome[i-1][i] = true;
        for (int i = 2; i < N; i++) {
            for (int j = 0; j + i< N; j++) {
                if (isPalindrome[j + 1][i + j - 1] && chars[j] == chars[j + i]) {
                    isPalindrome[j][i + j] = true;
                }
            }
        }
        int[] dp = new int[N];
        Arrays.fill(dp, 2501);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isPalindrome[j][i]){
                    if (j == 0) dp[i] = 1;
                    else dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        System.out.println(dp[N - 1]);
    }
}
