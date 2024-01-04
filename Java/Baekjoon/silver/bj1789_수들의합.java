package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1789_수들의합 {
	static long sum, N, S;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Long.parseLong(br.readLine());
		long a = 1;
		sum = N = 0;
		while(true) {
			if(a < S - sum - a) {
				sum += a;
				N++;
			}else if(S == sum+a) {
				sum += a;
				N++;
			}
			
			if(sum == S)break;
			a++;
		}
		System.out.println(N);
	}
}
