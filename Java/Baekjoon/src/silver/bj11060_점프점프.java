package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11060_점프점프 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(dp,10000);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= list[i]; j++) {
				if(i + j < N)dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}
		if(dp[N-1] == 10000) {
			System.out.println(-1);
			return;
		}
		System.out.println(dp[N-1]);

	}

}
