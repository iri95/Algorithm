package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7576_토마토 {
	static int[][] map;
	static List<int[]> posi1 = new ArrayList<>();
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int M, N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					int[] po1 = {i, j};
					posi1.add(po1);
				}
			}
		}
		bfs(posi1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(ans-1);
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
				for (int i = 0; i < 4; i++) {
					int ny = p[0] + dy[i];
					int nx = p[1] + dx[i];
					if (ny < 0 || ny >= N || nx < 0 || nx >= M)
						continue;
					if (map[ny][nx] == 0) {
						map[ny][nx] = 1;
						int[] np = {ny, nx};
						pos.offer(np);
					}else continue;

				}
			}

		}
	}
}
