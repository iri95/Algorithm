package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj25682_체스판다시칠하기2 {
	static int N, M, K, result;
	static boolean[][] map;
	static int[][] mapB, mapW;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][M + 1];
		mapB = new int[N + 1][M + 1];
		mapW = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				if (str.charAt(j-1) == 'B') {
					map[i][j] = true;

				}
			}
		}

		boolean a = false;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j]) {
					if (a) {
						mapW[i][j] = mapW[i - 1][j] + mapW[i][j-1] - mapW[i-1][j-1] + 1;
						mapB[i][j] = mapB[i - 1][j] + mapB[i][j-1] - mapB[i-1][j-1];
					} else {
						mapB[i][j] = mapB[i - 1][j] + mapB[i][j-1] - mapB[i-1][j-1] +1;
						mapW[i][j] = mapW[i - 1][j] + mapW[i][j-1] - mapW[i-1][j-1] ;
					}
				} else {
					if (a) {
						mapB[i][j] = mapB[i - 1][j] + mapB[i][j-1] - mapB[i-1][j-1] + 1;
						mapW[i][j] = mapW[i - 1][j] + mapW[i][j-1] - mapW[i-1][j-1] ;
					} else {
						mapW[i][j] = mapW[i - 1][j] + mapW[i][j-1] - mapW[i-1][j-1] + 1;
						mapB[i][j] = mapB[i - 1][j] + mapB[i][j-1] - mapB[i-1][j-1];
					}
				}
				a = !a;
			}
			if (M % 2 == 0) {
				a = !a;
			}
		}
		result = Integer.MAX_VALUE;
		for (int i = 0; i <= N - K; i++) {
			for (int j = 0; j <= M - K; j++) {
				result = Math.min(result,Math.min(mapB[i+K][j+K] - mapB[i][j+K] - mapB[i+K][j] + mapB[i][j], mapW[i+K][j+K] - mapW[i][j+K] - mapW[i+K][j] + mapW[i][j]));
			}
		}
		System.out.println(result);
	}
}
