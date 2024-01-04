package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class bj1010 {
	static int T, N, M;
	static BigInteger up, down;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			up = new BigInteger("1");
			down = new BigInteger("1");
			for (int j = 0; j < N; j++) {
				up = up.multiply(new BigInteger(String.valueOf(M - j)));
				down = down.multiply(new BigInteger(String.valueOf(j + 1)));
			}
			System.out.println(up.divide(down));
		}
	}
}
