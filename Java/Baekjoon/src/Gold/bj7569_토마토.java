package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7569_토마토 {
	static int[][][] map;
	static List<int[]> posi1 = new ArrayList<>();
	static int[] dy = { 1, -1, 0, 0, 0, 0};
	static int[] dx = { 0, 0, 1, -1, 0, 0};
	static int[] dh = { 0, 0, 0, 0, 1, -1};
	static int M, N, H, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if (map[h][i][j] == 1) {
						int[] po1 = { h, i, j };
						posi1.add(po1);
					}
				}
			}
		}

		bfs(posi1);
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[h][i][j] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(ans - 1);
	}

	static void bfs(List<int[]> posi) {
		Queue<int[]> pos = new ArrayDeque<>();
		for (int[] posi1 : posi) {
			pos.offer(posi1);
		}

		while (!pos.isEmpty()) {

			int size = pos.size();
			ans++;
			while (--size >= 0) {

				int[] p = pos.poll();
				for (int i = 0; i < 6; i++) {
					int nh = p[0] + dh[i];
					int ny = p[1] + dy[i];
					int nx = p[2] + dx[i];
					if (ny < 0 || ny >= N || nx < 0 || nx >= M || nh < 0 || nh >= H)
						continue;
					if (map[nh][ny][nx] == 0) {
						map[nh][ny][nx] = 1;
						int[] np = { nh, ny, nx };
						pos.offer(np);
					} else
						continue;

				}
			}

		}
	}
}
