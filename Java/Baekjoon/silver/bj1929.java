package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1929 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] select = new boolean[M + 1];
		select[0] = select[1] = true;
		for (int i = 2; i <= Math.sqrt(M); i++) {
			for (int j = i + i; j <= M; j += i) {
				if (select[j])
					continue;
				select[j] = true;
			}
		}
		for (int i = N; i <= M; i++) {
			if (!select[i]) {
				sb.append(i + "\n");
			}

		}
		System.out.println(sb);
	}

}
