package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj22871_징검다리건너기large {
	static int N;
	static long[] A, dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new long[N+1];
		dp = new long[N+1];
		int Max = Integer.MAX_VALUE;
		Arrays.fill(dp, Max);
		dp[1] = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Long.parseLong(st.nextToken());
			for (int j = 1; j < i; j++) {
				if(i == 2) {
					dp[2] = 1 + Math.abs(A[1] - A[2]);
				}else {
					dp[i] = Math.min(dp[i], Math.max((i - j) * ( 1 + Math.abs(A[i] - A[j])), dp[j]));
				}
			}
		}
		System.out.println(dp[N]);
	}

}
