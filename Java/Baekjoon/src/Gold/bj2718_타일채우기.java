package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2718_타일채우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        dp[1] = 1;
        dp[2] = 5;
        int sum1 = 1;
        int sum2 = 0;
        for (int i = 3; i < 100001; i++) {
            if(i %2 == 1){
                dp[i] = dp[i-1] + dp[i-2] * 4 + sum1 * 2 + sum2 * 3;
                sum2 += dp[i-2];
            }
            else {
                dp[i] = dp[i-1] + dp[i-2] * 4 + sum1 * 3 + sum2 * 2;
                sum1 += dp[i-2];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            sb.append(dp[k]).append("\n");
        }
        System.out.println(sb);
    }
}
