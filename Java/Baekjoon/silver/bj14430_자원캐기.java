package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14430_자원캐기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                int value = Integer.parseInt(st.nextToken());
                dp[i][j] = Math.max(dp[i - 1][j] + value, dp[i][j - 1] + value);
            }
        }
        System.out.println(dp[N][M]);
    }
}
