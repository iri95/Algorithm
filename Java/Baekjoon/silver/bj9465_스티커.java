package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9465_스티커 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] stiker = new int[2][N];

			if (N == 1) {
				int a1 = Integer.parseInt(br.readLine());
				int a2 = Integer.parseInt(br.readLine());
				sb.append(Math.max(a1, a2) + "\n");
			} else {
				for (int j1 = 0; j1 < 2; j1++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					for (int j2 = 0; j2 < N; j2++) {
						stiker[j1][j2] = Integer.parseInt(st.nextToken());
					}
				}

				stiker[0][1] = stiker[1][0] + stiker[0][1];
				stiker[1][1] = stiker[0][0] + stiker[1][1];

				for (int j = 2; j < N; j++) {
					stiker[0][j] = Math.max(stiker[0][j] + stiker[1][j - 1], stiker[0][j] + stiker[1][j - 2]);
					stiker[1][j] = Math.max(stiker[1][j] + stiker[0][j - 1], stiker[1][j] + stiker[0][j - 2]);
				}

				sb.append(Math.max(stiker[0][N - 1], stiker[1][N - 1]) + "\n");
			}

		}
		System.out.println(sb);

	}

}
