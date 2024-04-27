package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/board/view/60695
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
                /*
                    ex) coupon이 2개 있고, OOXXXXXXO 인 경우 3일권 하나 사는게 이득
                    하지만 처음 X 부분에서 3일권을 사지 않음.
                 */
                for (int j = 1; j <= 5; j += 2) {
                    if (i - j < 0) continue;
                    for (int k = 0; k <= 40; k++) {
                        if (k - coupon[j] >= 0) {
                            dp[i][k] = Math.min(dp[i - 1][k], dp[i - j][k - coupon[j]] + price[j]);
                        }
                    }
                }

                if (i == 3 && dp[3][0] != 1_000_000) dp[3][1] = price[3];
                if (i == 5 && dp[5][0] != 1_000_000) dp[5][2] = price[5];
                continue;
            }
            for (int j = 0; j <= 37; j++) dp[i][j] = dp[i - 1][j + 3];

            for (int j = 1; j <= 5; j += 2) {
                if (i - j < 0) break;
                for (int k = 0; k <= 40; k++) {
                    if (k - coupon[j] >= 0) {
                        dp[i][k] = Math.min(dp[i][k], dp[i - j][k - coupon[j]] + price[j]);
                    }
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