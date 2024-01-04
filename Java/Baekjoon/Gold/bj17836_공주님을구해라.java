package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17836_공주님을구해라 {
	static int[][] map;
	static boolean[][] visit;
	static int N, M, T;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if(map[N][M]> T || map[N][M] == 0) {
			System.out.println("Fail");
		}else {
			System.out.println(map[N][M]);
		}

	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 1, 1 });
		int turn = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			turn++;
			while (size-- > 0) {
				int[] p = queue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = dy[i] + p[0];
					int nx = dx[i] + p[1];
					if (ny <= 0 || ny > N || nx <= 0 || nx > M || map[ny][nx] == 1 || visit[ny][nx])
						continue;
					if(map[ny][nx] == 2) {
						if(map[N][M] != 0) {
							map[N][M] = Math.min(turn + (N - ny) + (M - nx), map[N][M]);
						}else {
							map[N][M] = turn + (N - ny) + (M - nx);
						}
					}
					if(ny == N && nx == M) {
						if(map[ny][nx] != 0) {
							map[ny][nx] = Math.min(map[ny][nx], turn);
							return;
						}
					}
					map[ny][nx] = turn;
					visit[ny][nx] = true;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
	}

}
