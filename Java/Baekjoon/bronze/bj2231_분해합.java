package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2231_분해합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 1; i < N; i++) {
			String a = Integer.toString(i);
			int k = i;
			for (int j = 0; j < a.length(); j++) {
				k += Character.getNumericValue(a.charAt(j));
			}
			if(k == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}

}
