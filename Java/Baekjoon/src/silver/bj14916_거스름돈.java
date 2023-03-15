package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj14916_거스름돈 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[100001];
		num[1] = Integer.MAX_VALUE;
		num[2] = 1;
		num[3] = Integer.MAX_VALUE;
		num[4] = 2;
		num[5] = 1;
		int n = Integer.parseInt(br.readLine());
		for (int i = 6; i <= n; i++) {
			num[i] = Math.min(num[i-2], num[i-5]) + 1;
		}
		if(n == 1 || n ==3) {
			System.out.println(-1);
		}else {
			System.out.println(num[n]);
		}
	}
}
