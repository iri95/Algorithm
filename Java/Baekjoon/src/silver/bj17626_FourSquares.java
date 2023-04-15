package silver;

import java.util.Scanner;

public class bj17626_FourSquares {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int k,min= Integer.MAX_VALUE;
			for (int j = 1; j <= (int) Math.sqrt(i); j++) {
				k = j*j;
				min = Math.min(dp[i-k]+1,min);
			}
			dp[i] = min;
		}
		System.out.println(dp[n]);
	}
}
