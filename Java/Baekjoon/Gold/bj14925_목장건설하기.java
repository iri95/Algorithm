package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14925_목장건설하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) dp[i][j] = st.nextToken().equals("0") ? 1 : -1;
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (dp[i][j] == -1 || dp[i - 1][j - 1] == -1 || dp[i - 1][j] == -1 || dp[i][j - 1] == -1) continue;
                int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                dp[i][j] = min + 1;
                if (dp[i][j] > ans) ans = dp[i][j];
            }
        }
        System.out.println(ans);
    }
}
