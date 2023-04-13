package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9095_123더하기 {
	static int[] dp = new int[12];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 12; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}

	}

}
