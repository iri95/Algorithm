package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2581 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] select = new boolean[M + 1];
		select[0] = select[1] = true;
		for (int i = 3; i <= M; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					select[i] = true;
			}
		}
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = M; i >= N; i--) {
			if (!select[i]) {
				sum += i;
				min = i;
			}

		}
		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
