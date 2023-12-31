package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9658_돌게임4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[1001];
        dp[0] = true;
        dp[2] = true;
        dp[4] = true;
        for (int i = 5; i < n + 1; i++) {
            if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4])
                dp[i] = true;
        }
        if (dp[n]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
