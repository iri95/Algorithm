package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj21317_징검다리건너기 {
	static int N, K;
	static int[][] dp = new int[2][20];
	static int[][] dol = new int[20][2];
	static int Max = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dol[i][0] = Integer.parseInt(st.nextToken());
			dol[i][1] = Integer.parseInt(st.nextToken());
		}
		K = Integer.parseInt(br.readLine());
		dp[0][1] = dol[0][0];
		dp[0][2] = Math.min(dp[0][1] + dol[1][0], dp[0][0] + dol[0][1]);
		dp[0][3] = Math.min(dp[0][2] + dol[2][0], dp[0][1] + dol[1][1]);
		dp[1][3] = K;
		dp[1][4] = Math.min(dol[3][0] + K, dol[0][0] + K);
		for (int i = 3; i < N; i++) {
			if(i >= 5) {
				dp[1][i] = Math.min(Math.min(dp[1][i-1] + dol[i-1][0], dp[1][i-2] + dol[i-2][1]), dp[0][i-3] + K);
			}
			dp[0][i] = Math.min(dp[0][i-1] + dol[i-1][0], dp[0][i-2] + dol[i-2][1]);
		}
		if(N <= 3) {
			System.out.println(dp[0][N-1]);
		}else {
			System.out.println(Math.min(dp[1][N-1], dp[0][N-1]));
		}
	}

}
