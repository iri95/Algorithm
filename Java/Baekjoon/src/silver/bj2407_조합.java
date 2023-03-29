package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class bj2407_조합 {
	static int n, m;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		BigInteger child = BigInteger.ONE;
		BigInteger parent = BigInteger.ONE;

		for (int i = 0; i < m; i++) {
			// 1 * n * n-1 * n-2 .... n - m + 1
			child = child.multiply(new BigInteger(String.valueOf(n - i))); // n - i
			parent = parent.multiply(new BigInteger(String.valueOf(i + 1))); // i + 1
			
		}
		
		System.out.println(child.divide(parent));
	}

}
