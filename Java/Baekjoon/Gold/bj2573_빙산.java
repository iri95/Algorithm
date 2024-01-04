package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2573_빙산 {
	static int N, M, cnt, mcnt;
	static int[][] map, temp;
	static boolean[][] visit;
	static Queue<int[]> queue = new ArrayDeque<>();
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		visit = new boolean[N][M];
		mcnt = 0;
		cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					queue.offer(new int[] { i, j });
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			if (visit[p[0]][p[1]])
				continue;
			block(p[0], p[1]);
			mcnt++;
		}
		if(mcnt != 1) {
			System.out.println(0);
			return;
		}
		
		while (mcnt == 1) {
			visit = new boolean[N][M];
			search();
			minus();
			mcnt = 0;
			while (!queue.isEmpty()) {
				int[] p = queue.poll();
				if (visit[p[0]][p[1]])
					continue;
				block(p[0], p[1]);
				mcnt++;
			}
			cnt++;
		}
		if (mcnt == 0) {
			System.out.println(0);
		} else {
			System.out.println(cnt);
		}

	}

	static void search() {
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (ny < 0 || nx < 0 || ny >= N || nx >= M)
							continue;
						if (map[ny][nx] == 0) {
							temp[i][j]++;
						}
					}
				}
			}
		}
	}

	static void minus() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = map[i][j] - temp[i][j] > 0 ? map[i][j] - temp[i][j] : 0;
				if (map[i][j] != 0)
					queue.offer(new int[] { i, j });
			}
		}
	}

	static void block(int y, int x) {
		visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0)
				continue;
			visit[ny][nx] = true;
			block(ny, nx);
		}
	}
}
