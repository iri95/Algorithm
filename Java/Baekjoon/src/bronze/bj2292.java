package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2292 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 1;
		int i = 2;
		if (n == 1) {
			System.out.println(1);
		} else {
			while (true) {
				count += (i - 1) * 6;
				if (n <= count) {
					System.out.println(i);
					break;
				}
				i++;
			}
		}
	}

}
