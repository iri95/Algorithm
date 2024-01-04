package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2636_치즈 {
	static int[][] map;
	static boolean[][] visit;
	static int h, w, cnt, szcnt, tempcnt;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		while (true) {
			int k = 0;
			tempcnt = 0;
			visit = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						k++;
					}
				}
			}
			if (k == 0)
				break;
			bfs(0, 0);
			szcnt = tempcnt;
			cnt++;
		}

		System.out.println(cnt);
		System.out.println(szcnt);

	}

	static void bfs(int y, int x) {
		queue.offer(new int[] { y, x });
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p[0] + dy[i];
				int nx = p[1] + dx[i];
				if (ny < 0 || nx < 0 || ny >= h || nx >= w || visit[ny][nx])
					continue;
				if (map[ny][nx] == 1) {
					map[ny][nx] = 0;
					tempcnt++;
					visit[ny][nx] = true;
					continue;
				}
				visit[ny][nx] = true;
				queue.offer(new int[] { ny, nx });
			}

		}
	}
}
