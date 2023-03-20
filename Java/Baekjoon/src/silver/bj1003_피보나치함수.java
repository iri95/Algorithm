package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1003_피보나치함수 {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cnt1 = new int[41];
		int[] cnt0 = new int[41];
		cnt1[1] = 1;
		cnt0[0] = 1;
		for (int i = 2; i < 41; i++) {
			cnt1[i] = cnt1[i-1] + cnt1[i-2];
			cnt0[i] = cnt0[i-1] + cnt0[i-2];
		}
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(cnt0[n] + " " + cnt1[n]);
		}
		
	}

}
