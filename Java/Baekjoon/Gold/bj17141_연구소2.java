package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17141_연구소2 {
	static int N, M, min, cnt, count2;
	static boolean resultT;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map, tgt;
	static int[][] posi2;
	static boolean[][] visit, result;
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		result = new boolean[N][N];
		tgt = new int[M][2];

		min = Integer.MAX_VALUE;
		count2 = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					count2++;
				} else if (map[i][j] == 1) {
					visit[i][j] = true;
				}
			}
		}
		posi2 = new int[count2][2];
		int p = 0;
		for (int i = 0; i < N; i++) {
			if (p == count2)
				break;
			for (int j = 0; j < N; j++) {
				if (p == count2)
					break;
				if (map[i][j] == 2) {
					posi2[p] = new int[] { i, j };
					p++;
				}
			}
		}
		comb(0, 0);
		if (min != Integer.MAX_VALUE) {
			System.out.println(min);
		} else {
			System.out.println(-1);
		}

	}

	// bfs
	static void bfs() {
		cnt = -1;
		while (!queue.isEmpty()) {
			cnt++;
			int size = queue.size();
			while (size-- > 0) {
				int[] b = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nx = b[1] + dx[i];
					int ny = b[0] + dy[i];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N || result[ny][nx])
						continue;
					queue.offer(new int[] { ny, nx });
					result[ny][nx] = true;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!result[i][j]) {
					return;
				}
			}
		}
		min = Math.min(min, cnt);
	}

	// comb
	static void comb(int tgtIdx, int a) {
		if (tgtIdx == M) {
			invalid();
			for (int[] i : tgt) {
				result[i[0]][i[1]] = true;
				queue.offer(i);
			}
			bfs();
			return;
		}
		if (a == count2)
			return;

		tgt[tgtIdx] = posi2[a];
		comb(tgtIdx + 1, a + 1);
		comb(tgtIdx, a + 1);
	}

	// result 초기화
	static void invalid() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = visit[i][j];
			}
		}
	}
}