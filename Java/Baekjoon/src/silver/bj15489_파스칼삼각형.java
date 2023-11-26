package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15489_파스칼삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        long[][] dp = new long[31][31];
        for (int i = 1; i < 31; i++) {
            dp[1][i] = 1;
            dp[i][1] = 1;
        }
        for (int i = 2; i < 31; i++) {
            for (int j = 2; j < 31; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        long sum = 0;
        int cnt = W;
        for (int i = R - C + 1; i < R - C + 1 + W; i++) {
            for (int j = C; j < C + cnt; j++) {
                sum += dp[i][j];
            }
            cnt--;
        }
        System.out.println(sum);
    }
}
