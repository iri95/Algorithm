package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj4097_수익 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int[] list = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = Integer.parseInt(br.readLine());
            }
            int[] dp = new int[N + 1];
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                dp[i] = Math.max(dp[i - 1] + list[i], list[i]);
                max = Math.max(dp[i], max);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
