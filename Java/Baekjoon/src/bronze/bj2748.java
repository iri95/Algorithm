package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2748 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] pibo = new long[N + 1];
		pibo[0] = 0;
		pibo[1] = 1;
		if (pibo.length > 2) {
			for (int i = 2; i <= N; i++) {
				pibo[i] = pibo[i - 1] + pibo[i - 2];
			}
		}
		System.out.println(pibo[pibo.length - 1]);
	}
}
