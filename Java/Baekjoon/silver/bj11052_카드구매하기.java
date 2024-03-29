package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11052_카드구매하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
