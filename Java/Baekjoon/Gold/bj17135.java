package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class bj17135 {

	static char[][] pan, panC;
	static int N, M, D;
	static int ty, tx;
	static int COUNT = 0;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		pan = new char[N][M];
		panC = new char[N][];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				char c = st.nextToken().charAt(0);
				pan[i][j] = c;
				if (c == '1')
					COUNT++;
			}
		}

		int cnt;
		Set<int[]> set;
		Iterator<int[]> iter;
		for (int i = 0; i < M - 2; i++) {
			for (int j = i + 1; j < M - 1; j++) {
				for (int k = j + 1; k < M; k++) {

					for (int m = 0; m < N; m++)
						panC[m] = Arrays.copyOf(pan[m], M);

					for (int n = N; n > 0; n--) {
						set = new HashSet<>();
						set.add(kill(n, i));
						set.add(kill(n, j));
						set.add(kill(n, k));

						iter = set.iterator();
						while (iter.hasNext()) {
							int[] t = iter.next();
							if (t[0] >= 0) // 죽일수 있는게 있을 때
								panC[t[0]][t[1]] = '0';
						}
					}

					cnt = 0;
					for (int c1 = 0; c1 < N; c1++) {
						for (int c2 = 0; c2 < M; c2++) {
							if (panC[c1][c2] == '1')
								cnt++;
						}
					}
					ans = Math.max(ans, COUNT - cnt);
				}
			}
		}
		System.out.println(ans);
	}

	private static int[] kill(int y, int x) {
		for (int i = 1; i <= D; i++) {
			for (int j = 0; j <= (i * 2 - 1) / 2; j++) {
				ty = y - j - 1;
				tx = x - i + j + 1;
				if (ty < 0 || ty >= N || tx < 0 || tx >= M) {
				} else if (panC[ty][tx] == '1') {
					return new int[] { ty, tx };
				}
			}
			for (int j = 0; j < (i * 2 - 1) / 2; j++) {
				ty = y - i + j + 1;
				tx = x + j + 1;
				if (ty < 0 || ty >= N || tx < 0 || tx >= M) {
				} else if (panC[ty][tx] == '1') {
					return new int[] { ty, tx };
				}
			}
		}
		return new int[] { -1, -1 };
	}
}