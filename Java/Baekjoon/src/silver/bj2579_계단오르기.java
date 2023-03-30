package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2579_계단오르기 {
	static int[] dp;
	static int[] stair;
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		stair = new int[N+2];
		dp = new int[N+2];
		for (int i = 0; i < N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = stair[0];
		dp[1] = stair[1] + stair[0];
		dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i-3] + stair[i-1]+ stair[i], dp[i-2] + stair[i]);
		}
		System.out.println(dp[N-1]);
	}

}