package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bj1837 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		BigInteger c = new BigInteger(a[0]);
		BigInteger d = new BigInteger(a[1]);

		for (BigInteger i = new BigInteger("2"); i.compareTo(c) == -1; i = i.add(BigInteger.ONE)) {
			if (i.compareTo(d) != -1) {
				sb.append("GOOD");
				break;
			}
			if (c.remainder(i).compareTo(BigInteger.ZERO) == 0 && i.compareTo(d) == -1) {
				sb.append("BAD " + i);
				break;
			}
		}
		System.out.println(sb);
	}

}
