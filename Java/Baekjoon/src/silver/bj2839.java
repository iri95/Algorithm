package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2839 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int t = N/5;
		int result5 = 0,result3 = -3;
		for (int i = 0; i <= t; i++) {
			int a = 5*i;
			if((N-a)%3 == 0) {
				result3 =(N-a);
				result5 = a;
			}
		}
		System.out.println(result5/5 + result3/3);
	}

}
