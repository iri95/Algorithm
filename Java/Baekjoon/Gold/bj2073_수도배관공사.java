package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2073_수도배관공사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] dp = new int[D + 1];
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            for (int j = D; j - L > 0; j--) {
                if (dp[j - L] == 0) continue;
                dp[j] = Math.max(Math.min(dp[j - L], C), dp[j]);
            }
            dp[L] = Math.max(C, dp[L]);
        }
        System.out.println(dp[D]);
    }
}
