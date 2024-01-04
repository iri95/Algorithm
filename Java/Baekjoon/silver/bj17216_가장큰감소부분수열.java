package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17216_가장큰감소부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		dp[0] = list[0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (list[i] < list[j]) {
					dp[i] = Math.max(dp[i], dp[j] + list[i]);
				}
			}
			if(dp[i] == 0) dp[i] = list[i];
			max = Math.max(dp[i], max);
		}
		System.out.println(max);

	}

}
