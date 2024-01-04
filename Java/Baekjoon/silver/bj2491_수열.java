package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2491_수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n + 1];
        long[][] dp = new long[2][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp[0], 1);
        Arrays.fill(dp[1], 1);
        dp[0][0] = dp[1][0] = 0;
        for (int i = 1; i <= n; i++) {
            if (list[i] >= list[i - 1]) {
                dp[0][i] = Math.max(dp[0][i - 1] + 1, dp[0][i]);
            }
            if (list[i] <= list[i-1]) {
                dp[1][i] = Math.max(dp[1][i - 1] + 1, dp[1][i]);

            }
        }
        long max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[0][i], max);
            max = Math.max(dp[1][i], max);
        }
        System.out.println(max);
    }
}
