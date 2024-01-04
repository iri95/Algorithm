package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18353_병사배치하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n + 1];
        long[] dp = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        list[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= n ; i++) {
            for (int j = n-1; j >= 0; j--) {
                if (list[i] < list[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        long max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(n - max);
    }
}
