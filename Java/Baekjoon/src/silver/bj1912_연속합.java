package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1912_연속합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}
		int max = dp[0];
		for (int i = 1; i < N; i++) {
			if(dp[i-1]>0 && dp[i] + dp[i-1] > 0) {
				dp[i] += dp[i-1];
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(max);

	}

}
