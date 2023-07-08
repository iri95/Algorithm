package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2758_로또 {
    static int n,m;
    static long[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            dp = new long[n][m+1];
            Arrays.fill(dp[0], 1);
            for (int t = 0; t < n-1; t++) {
                for (int j = 1; j <= m; j++) {
                    for (int k = j*2; k <= m; k++) {
                        dp[t + 1][k] += dp[t][j];
                    }
                }
            }
            long sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += dp[n - 1][j];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
