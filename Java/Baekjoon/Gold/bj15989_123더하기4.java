package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj15989_123더하기4 {
    static int[] dp = new int[10_0001];
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp();
        while (T-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
    static void dp(){
        Arrays.fill(dp, 1);
        for (int i = 2; i <= 3; i++) {
            for (int j = 0; j <= 10000; j++) {
                dp[j + i] += dp[j];
            }
        }
    }
}
