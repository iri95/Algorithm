package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj4883_삼각그래프 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0)break;
            long[][] dp = new long[N + 1][5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            dp[1][0] = 100000000;
            dp[1][4] = 100000000;
            dp[1][1] = 100000000;
            dp[1][2] = Long.parseLong(st.nextToken());
            dp[1][3] = dp[1][2] + Long.parseLong(st.nextToken());
            for (int i = 2; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine());
                dp[i][0] = 100000000;
                dp[i][4] = 100000000;
                for (int j = 1; j < 4; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + value, Math.min(dp[i - 1][j] + value, Math.min(dp[i - 1][j + 1] + value, dp[i][j - 1] + value)));
                }
            }
            sb.append(T + ". ").append(dp[N][2]).append("\n");
            T++;
        }
        System.out.println(sb);
    }
}
