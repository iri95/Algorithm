package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1309_동물원 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 3][3];
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		dp[2][0] = 3;
		dp[2][1] = 2;
		dp[2][2] = 2;
		for (int i = 3; i < N+1; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
		}
		System.out.println((dp[N][0] + dp[N][1] + dp[N][2])%9901);
		
	}

}
