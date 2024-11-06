package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class bj5626_제단 {
    public static void main(String[] args) throws Exception {
        int div = 1_000_000_007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
            if (answer[i] > Math.min(i, N - 1 - i)) {
                System.out.println(0);
                return;
            }
        }

        int[][] dp = new int[N][(N + 1) / 2 + 1];
        dp[0][0] = 1;
        for (int i = 1; i < N; i++) {
            if (answer[i] == -1) {
                for (int j = 0; j <= Math.min(i, N - 1 - i); j++) {
                    for (int k = -1; k <= 1; k++) {
                        if (j + k < 0) continue;
                        dp[i][j] += dp[i - 1][j + k];
                        dp[i][j] %= div;
                    }
                }
            } else {
                for (int k = -1; k <= 1; k++) {
                    if (answer[i] + k < 0) continue;
                    dp[i][answer[i]] += dp[i - 1][answer[i] + k];
                    dp[i][answer[i]] %= div;
                }
            }
        }
        System.out.println(dp[N - 1][0]);
    }
}
