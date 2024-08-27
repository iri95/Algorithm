package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복 조합 -> (N + 1)H(M) -> (N + M)C(M)
// https://usedto-wonderwhy.tistory.com/177
public class bj1256_사전 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[][] dp = new long[201][201];
        for (int i = 0; i <= 200; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int i = 1; i <= 200; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                if (dp[i][j] > 1_000_000_000) dp[i][j] = 1_000_000_001;
            }
        }
        if (dp[M + N][M] < K) {
            System.out.println("-1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (!(N == 0 && M == 0)) {
            if (dp[M + N - 1][M] >= K) {
                sb.append("a");
                N--;
            } else {
                sb.append("z");
                K = K - dp[M + N - 1][M];
                M--;
            }
        }
        System.out.print(sb);
    }
}
