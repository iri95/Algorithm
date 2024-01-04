package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2240_자두나무 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[T + 1][W + 1];
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= T; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 2) { // 2일경우
                for (int j = 0; j <= W; j++) {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j];
                        continue;
                    }
                    if (j % 2 != 0) { // 나눠서 1이면 2번 자리에 있다는 뜻
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
                    } else { // 1번 자리
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            } else { // 1일 경우
                for (int j = 0; j <= W; j++) {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + 1;
                        continue;
                    }
                    if (j % 2 != 0) { // 2번 자리
                        dp[i][j] = dp[i - 1][j];
                    } else { // 1 번 자리
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < W + 1; i++) {
            max = Math.max(max, dp[T][i]);
        }
        System.out.println(max);
    }
}
