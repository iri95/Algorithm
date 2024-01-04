package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2011_암호코드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] list = br.readLine().toCharArray();
        int[] dp = new int[list.length + 1];
        int divide = 1000000;
        if (list[0] == '0') {
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < list.length + 1; i++) {
            String k = Character.toString(list[i - 2]) + Character.toString(list[i - 1]);
            if (k.equals("00")) {
                System.out.println(0);
                return;
            }
            if (list[i - 1] == '0') {
                if (Integer.parseInt(k) > 26) {
                    System.out.println(0);
                    return;
                }
            } else {
                dp[i] += dp[i - 1];
            }
            if (list[i - 2] != '0' && Integer.parseInt(k) <= 26) {
                dp[i] += dp[i - 2];
            }
            dp[i] %= divide;

        }
        System.out.println(dp[list.length] % divide);
    }

}
