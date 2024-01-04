package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17144 {
	// 미세먼지의 확산은 queue에 넣어서 한번만 처리하는 함수 작성
	// 델타사용해 주변의 값에 더하기
	// 공기청정기의 정화는 0이 아닌 값을 만날경우 위치 변경, 공기청정기의 위치로 들어올 경우 0으로 변환
	// 입력 -1 이 공기청정기의 위치
	static int[][] map;
	static int R, C, T;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int t = 1; t <= T; t++) {
			spread();
			move();
		}
		int sum = 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);

	}

	// 미세먼지 확산 함수(1번만)
	static void spread() {
		Queue<int[]> pos = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					int[] a = { i, j, map[i][j]};
					pos.add(a);
				}
			}
		}
		while (!pos.isEmpty()) {
			int[] p = pos.poll();
			int minus = 0;
			for (int i = 0; i < 4; i++) {
				int ny = p[0] + dy[i];
				int nx = p[1] + dx[i];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == -1)
					continue;
				map[ny][nx] += p[2] / 5;
				minus += p[2] / 5;

			}
			map[p[0]][p[1]] -= minus;
		}
	}

	// 공기청정기 미세먼지 칸 이동 및 제거 함수
	static void move() {
		List<int[]> p = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1) {
					int[] a = { i, j };
					p.add(a);
				}
			}
		}
		int y1 = p.get(0)[0];
		int x1 = p.get(0)[1];
		int y2 = p.get(1)[0];
		int x2 = p.get(1)[1];
		map[y1 - 1][x1] = 0;
		map[y2 + 1][x2] = 0;

		// 위의 공기청정기
		// 시계방향으로 앞의 값을 가져옴
		for (int i = y1 - 1; i > 0; i--) {
			map[i][x1] = map[i - 1][x1];
		}

		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}

		for (int i = 0; i < y1; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}

		for (int i = C - 1; i > 1; i--) {
			map[y1][i] = map[y1][i - 1];
		}

		// 아래의 공기청정기
		for (int i = y2 + 1; i < R - 1; i++) {
			map[i][x1] = map[i + 1][x1];
		}

		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}

		for (int i = R - 1; i > y1; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}

		for (int i = C - 1; i > 1; i--) {
			map[y2][i] = map[y2][i - 1];
		}
		map[y1][x1 + 1] = 0;
		map[y2][x2 + 1] = 0;
	}
}
