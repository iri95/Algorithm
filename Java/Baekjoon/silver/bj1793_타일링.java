package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bj1793_타일링 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = new BigInteger("3");
        for (int i = 3; i < 251; i++) {
            dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.TWO));
        }
        while(true){
            String k = br.readLine();
            if(k == null)break;
            int key = Integer.parseInt(k);
            System.out.println(dp[key]);
        }
    }
}
