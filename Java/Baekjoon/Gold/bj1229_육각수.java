package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1229_육각수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int Min = Integer.MAX_VALUE;
            for (int j = 1; i - j * (2 * j - 1) >= 0; j++) {
                Min = Math.min(Min, dp[i - j * (2 * j - 1)]);
            }
            dp[i] = Min + 1;
        }
        System.out.println(dp[N]);
    }
}
