package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14863_서울에서경산까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
                K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        int t1, t2, m1, m2;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            t1 = Integer.parseInt(st.nextToken());
            m1 = Integer.parseInt(st.nextToken());
            t2 = Integer.parseInt(st.nextToken());
            m2 = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= K; j++) {
                if (dp[i - 1][j] == -1) continue;
                if (j + t1 <= K) {
                    dp[i][j + t1] = Math.max(dp[i][j + t1], dp[i - 1][j] + m1);
                }
                if (j + t2 <= K) {
                    dp[i][j + t2] = Math.max(dp[i][j + t2], dp[i - 1][j] + m2);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= K; i++) {
            ans = Math.max(ans, dp[N][i]);
        }
        System.out.println(ans);
    }
}
