package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj1193 {
	static int x;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine());
		int i = 1;
		int count = 0;
		while (true) {
			count += i;
			if (x - count <= 0) {
				count -= i;
				x -= count;
				break;

			}
			i++;

		}
		if (i % 2 == 1) {
			System.out.println((i - x + 1) + "/" + x );
		} else {
			System.out.println(x + "/" + (i - x + 1));
		}
	}

}
