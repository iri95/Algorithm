package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2018_수들의합5 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		for (int i = 1; i < n/2 + 1; i++) {
			int sum = 0;
			for (int j = i; j <= n/2 + 1; j++) {
				sum += j;
				if(sum == n) {
					cnt++;
					break;
				}
				if(sum > n) break;
				
			}
		}
		System.out.println(cnt);
	}
}
