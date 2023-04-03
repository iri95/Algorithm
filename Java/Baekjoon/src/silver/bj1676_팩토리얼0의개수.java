package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1676_팩토리얼0의개수 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum5 = 0;
		int sum2 = 0;
		for (int i = 1; i <= N; i++) {
			int num5 = 0;
			int num2 = 0;
			int k = i;
			while(k% 2 == 0 || k % 5 == 0) {
				if(k%2 == 0) {
					num2++;
					k = k/2;
				}else if(k%5 == 0) {
					num5++;
					k = k/5;
				}
			}
			sum5 += num5;
			sum2 += num2;
		}
		System.out.println(Math.min(sum5, sum2));
	}
}
