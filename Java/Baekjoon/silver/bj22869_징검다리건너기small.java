package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj22869_징검다리건너기small {
	static int N, K;
	static long[] A, dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new long[N+1];
		dp = new long[N+1];
		int Max = Integer.MAX_VALUE;
		Arrays.fill(dp, Max);
		dp[1] = 0;
		st = new StringTokenizer(br.readLine());
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
		if(dp[N] > K) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
	}

}
