package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj13302_리조트 {
    static int[] price = {0, 10000, 0, 25000, 0, 37000};
    static int[] coupon = {0, 0, 0, 1, 0, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][41];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], 1_000_000);
        }
        dp[0][0] = 0;
        boolean[] visited = new boolean[N + 1];
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) visited[Integer.parseInt(st.nextToken())] = true;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            for (int j = 1; j <= 5; j += 2) {
                if (i - j < 0) continue;
                for (int k = 0; k <= 40; k++) {
                    if (k - coupon[j] >= 0) dp[i][k] = Math.min(dp[i][k], dp[i - j][k - coupon[j]] + price[j]);
                    if (k + 3 <= 40) dp[i][k] = Math.min(dp[i][k], dp[i - 1][k + 3]);
                }
            }
        }
        int ans = dp[N][0];
        for (int i = 1; i <= 40; i++) {
            ans = Math.min(dp[N][i], ans);
        }
        System.out.println(ans);
    }
}
