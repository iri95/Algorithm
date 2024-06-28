package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14722_우유도시 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[N + 1][N + 1];
        int[][][] dp = new int[3][N + 1][N + 1]; // y, x, 먹은 우유
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) dp[0][i][j] = 1;
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int nowMilk = map[i][j];
                for (int k = 0; k < 3; k++) {
                    int beforeMilk = (k + 2) % 3;
                    dp[k][i][j] = Math.max(dp[k][i][j],Math.max(dp[k][i - 1][j], dp[k][i][j - 1]));
                    if (nowMilk == k) {
                        if (dp[beforeMilk][i - 1][j] == 0 && dp[beforeMilk][i][j - 1] == 0) continue;
                        dp[k][i][j] = Math.max(dp[k][i][j], Math.max(dp[beforeMilk][i - 1][j], dp[beforeMilk][i][j - 1]) + 1);
                    }
                }
            }
        }
        int ans = Math.max(dp[0][N][N], Math.max(dp[1][N][N], dp[2][N][N]));
        System.out.println(ans);
    }
}
