package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://velog.io/@hahahaa8642/%EB%B0%B1%EC%A4%80-1987%EB%B2%88-%EC%95%8C%ED%8C%8C%EB%B2%B3-JAVA-%ED%92%80%EC%9D%B4
// hahahaa8642님 풀이
public class bj1987 {
	static int R, C, max_count= Integer.MIN_VALUE;
	static char[][] map;
	// 델타법
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	// 문자여도 boolean을 이용하는 법 기억하기
	static boolean[] visited = new boolean[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] a = br.readLine().toCharArray();
			map[i] = a;
		}
		dfs(0, 0, 0);
		System.out.println(max_count);
	}

	static void dfs(int y, int x, int count) {
		if (visited[map[y][x] - 'A']) {
			max_count = Math.max(max_count, count);
			return;
		} else {
			visited[map[y][x] - 'A'] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (ny < 0 || nx < 0 || ny >= R || nx >= C)
					continue;
				dfs(ny, nx, count + 1);
			}
			visited[map[y][x] - 'A'] = false;
		}
	}
}