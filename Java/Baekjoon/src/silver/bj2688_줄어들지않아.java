package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2688_줄어들지않아 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[][] list = new long[65][10];
		long[] dp = new long[65];
		for (int i = 0; i < 10; i++) {
			list[1][i] = 1;
		}
		for (int i = 2; i < 65; i++) {
			for (int j = 0; j < 10; j++) {
				list[i][0] += list[i-1][j];
			}
			for (int j = 1; j < 10; j++) {
				list[i][j] = list[i][j-1] - list[i-1][j-1];
			}
		}
		for (int i = 1; i < 65; i++) {
			for (int j = 0; j < 10; j++) {
				dp[i] += list[i][j];
			}
		}
		for (int i = 0; i < T; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}

}
