package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2228_구간나누기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -32768 * 101);
        }
        dp[0][0] = list[0];
        for (int i = 1; i < N - 2 * (M - 1); i++) {
            dp[0][i] = Math.max(dp[0][i - 1] + list[i], list[i]);
        }
        for (int i = 1; i < M; i++) {
            for (int j = i * 2; j < N - 2 * (M - i - 1); j++) {
                dp[i][j] = dp[i][j - 1] + list[j];
                for (int k = j - 2; k >= (i - 1) * 2; k--) {
                    dp[i][j] = Math.max(dp[i - 1][k] + list[j], dp[i][j]);
                }
            }
        }
        int result = -32768 * 101;
        for (int k : dp[M - 1]) {
            result = Math.max(result, k);
        }
        System.out.println(result);
    }
}
