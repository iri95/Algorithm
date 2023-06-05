package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1535_안녕 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] L = new int[N];
		int[] J = new int[N];
		int[] dp = new int[100];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int k = 99; k >= 0; k--) {
				int energy = L[i] + k;
				if(energy< 100) {
					dp[energy] = Math.max(dp[energy], dp[k] + J[i]);
				}
			}
		}
		System.out.println(dp[99]);
	}

}
