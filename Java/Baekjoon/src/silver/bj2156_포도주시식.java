package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2156_포도주시식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		if (n == 1) {
			System.out.println(list[0]);
			return;
		} else if (n == 2) {
			System.out.println(list[0] + list[1]);
			return;
		} else if (n == 3) {
			int a1 = list[0] + list[1];
			int a2 = list[1] + list[2];
			int a3 = list[0] + list[2];
			System.out.println(Math.max(a1, Math.max(a2, a3)));
			return;
		}
		dp[0] = list[0];
		dp[1] = list[0] + list[1];
		dp[2] = Math.max(list[0] + list[1], Math.max(list[0] + list[2], list[1] + list[2]));
		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i-1],Math.max(dp[i - 2] + list[i], dp[i - 3] + list[i - 1] + list[i]));
		}
		System.out.println(dp[n-1]);

	}

}
