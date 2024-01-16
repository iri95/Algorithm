package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2302_극장좌석 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] list = new int[N + 1];
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < 41; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        int minus = 0;
        int result = 1;
        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(br.readLine());
            result *= dp[k - minus - 1];
            minus = k;
        }
        result *= dp[N - minus];
        System.out.println(result);
    }
}
