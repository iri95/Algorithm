package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1861 {
	static int N, max, start, count, lastMax;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] A;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			A = new int[N][N];
			start = Integer.MAX_VALUE;
			lastMax = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count = 0;
					max = Integer.MIN_VALUE;
					move(j, i, A[i][j] - 1);
					if (max > lastMax) {
						start = A[i][j];
						lastMax = max;
					}else if(max == lastMax) {
						start = (A[i][j] < start) ? A[i][j] : start;
					}
				}
			}
			sb.append("#" + t + " " + start + " " + lastMax + "\n");
		}
		System.out.println(sb);
	}

	static void move(int x, int y, int value) {
		if (value + 1 != A[y][x]) {
			return;
		} else {
			value = A[y][x];
			count++;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				else {
					move(nx, ny, value);
				}
			}
		}
		max = Math.max(max, count);
	}
}
