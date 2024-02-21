package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://h-yeon00.tistory.com/39
public class bj19645_햄최몇 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N + 1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            sum += list[i];
        }
        boolean[][] dp = new boolean[sum + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = sum; j >= 0; j--) {
                for (int k = sum - j; k >= 0; k--) {
                    if (j - list[i] >= 0) dp[j][k] = dp[j - list[i]][k] || dp[j][k];
                    if (k - list[i] >= 0) dp[j][k] = dp[j][k - list[i]] || dp[j][k];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= i; j++) {
                int k = sum - i - j;
                if (dp[i][j] && k <= j) ans = Math.max(ans, k);
            }
        }
        System.out.println(ans);
    }
}
