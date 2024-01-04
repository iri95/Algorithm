package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj10844_쉬운계단수 {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n+1][10];
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		int k = 1000000000;
		for (int i = 2; i < n+1; i++) {	
			dp[i][0] = dp[i-1][1]%k;
			dp[i][1] = dp[i-1][0]%k + dp[i-1][2]%k;
			dp[i][2] = dp[i-1][1]%k + dp[i-1][3]%k;
			dp[i][3] = dp[i-1][2]%k + dp[i-1][4]%k;
			dp[i][4] = dp[i-1][3]%k + dp[i-1][5]%k;
			dp[i][5] = dp[i-1][4]%k + dp[i-1][6]%k;
			dp[i][6] = dp[i-1][5]%k + dp[i-1][7]%k;
			dp[i][7] = dp[i-1][6]%k + dp[i-1][8]%k;
			dp[i][8] = dp[i-1][7]%k + dp[i-1][9]%k;
			dp[i][9] = dp[i-1][8]%k;
		}
		long result = 0;
		for (int i = 1; i < 10; i++) {
			result += dp[n][i];
		}
		result%=1000000000;
		System.out.println(result);
		
	}
}
