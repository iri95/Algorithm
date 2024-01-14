package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj14226_이모티콘 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 2; i < 1001; i++) {
            dp[i] = Math.min(dp[i], i);
            for (int j = 2; j * i < 1001; j++) {
                dp[i * j] = Math.min(dp[i * j], dp[i] + 2 + (j - 2));
                for (int k = i * j - 1; k > i * (j - 1); k--) {
                    dp[k] = Math.min(dp[k], dp[k + 1] + 1);
                }
            }
        }
        System.out.println(dp[N]);
    }
}
