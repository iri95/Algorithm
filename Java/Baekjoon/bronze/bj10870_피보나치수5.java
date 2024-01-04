package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj10870_피보나치수5 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] pibo = new int[21];
		pibo[0] = 0;
		pibo[1] = 1;
		for (int i = 2; i <= 20; i++) {
			pibo[i] = pibo[i-1] + pibo[i-2];
		}
		System.out.println(pibo[n]);
	}

}
