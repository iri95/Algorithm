package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj4948 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			boolean[] select = new boolean[2 * N + 1];
			select[0] = select[1] = true;
			for (int i = 2; i <= Math.sqrt(2 * N); i++) {
				for (int j = i + i; j <= 2 * N; j += i) {
					if (select[j])
						continue;
					select[j] = true;
				}
			}
			for (int i = N+1; i <= 2 * N; i++) {
				if (!select[i]) {
					count++;
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
}
