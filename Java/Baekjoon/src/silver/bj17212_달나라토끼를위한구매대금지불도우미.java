package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj17212_달나라토끼를위한구매대금지불도우미 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = 1;
		for (int i = 8; i <= N; i++) {
			dp[i] = Math.min(Math.min(dp[i-1] + 1, dp[i - 2]+ 1), Math.min(dp[i-5] + 1, dp[i - 7]+ 1));
		}
		System.out.println(dp[N]);

	}

}
