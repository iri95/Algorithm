package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2225_합분해 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] dp = new long[K + 1][N + 1];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= j ; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(dp[K][N]%1000000000);

    }


}
