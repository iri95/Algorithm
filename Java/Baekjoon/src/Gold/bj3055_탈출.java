package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj3055_탈출 {
	static int R, C, ans = 0, result;
	static int[] S, D;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { 1, -1, 0, 0 };
	static List<int[]> water = new ArrayList<>();
	static Queue<int[]> queue = new ArrayDeque<>();
	static Queue<int[]> Squeue = new ArrayDeque<>();
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String a = br.readLine();
			map[i] = a.toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S')
					S = new int[] { i, j };
				else if (map[i][j] == 'D')
					D = new int[] { i, j };
				else if (map[i][j] == '*')
					water.add(new int[] { i, j });
			}
		}
		// bfs로 물 확산 후 -> 고슴도치 이동
		bfs();
		if(map[D[0]][D[1]] == 'D')System.out.println("KAKTUS");
		else System.out.println(result);

	}


	static void bfs() {
		// 한번 하기 전에 queue를 초기화 해준다.
		for (int i = 0; i < water.size(); i++) {
			queue.offer(water.get(i));
		}
		Squeue.offer(S);
		while (!queue.isEmpty() || !Squeue.isEmpty()) {
			++ans;
			
			// 물 확산
			int size = queue.size();
			while (size-- > 0) {
				int[] p = queue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = p[0] + dy[i];
					int nx = p[1] + dx[i];
					if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == '*' || map[ny][nx] == 'X'
							|| (ny == D[0] && nx == D[1]))
						continue;
					map[ny][nx] = '*';
					queue.offer(new int[] { ny, nx });
				}
			}
			
			// 이동
			int Ssize = Squeue.size();
			while (Ssize-- > 0) {
				int[] p = Squeue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = p[0] + dy[i];
					int nx = p[1] + dx[i];
					if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == '*' || map[ny][nx] == 'X'
							|| visit[ny][nx])
						continue;
					visit[ny][nx] = true;
					if (map[ny][nx] == 'D') {
						map[ny][nx] = 'S';
						result = ans;
						break;
					}
					Squeue.offer(new int[] { ny, nx });
				}
			}

		}
	}
}