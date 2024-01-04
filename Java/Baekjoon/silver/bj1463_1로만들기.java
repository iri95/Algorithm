package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1463_1로만들기 {

	public static void main(String[] args) throws Exception {
		int[] dp = new int[1000001];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 4; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			if (i % 3 == 0) {
				min = Integer.min(dp[i / 3] + 1, min);
			}
			if (i % 2 == 0) {
				min = Integer.min(dp[i / 2] + 1, min);
			}
			dp[i] = Integer.min(min, dp[i - 1] + 1);
		}
		System.out.println(dp[N]);
	}
}
