package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9020 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		boolean[] select = new boolean[10001];
		select[0] = select[1] = true;
		for (int i = 2; i <= 100; i++) {
			if (select[i])
				continue;
			for (int j = i + i; j <= 10000; j += i) {
				select[j] = true;
			}
		}
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int a = 0, b = 0;
			for (int i = 2; i <= N / 2; i++) {
				if (select[i])
					continue;
				if (!select[i] && !select[N - i]) {
					a = i;
					b = N - i;
				}
			}
			sb.append(a + " " + b + "\n");
		}
		System.out.println(sb);
	}
}
