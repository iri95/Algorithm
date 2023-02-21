package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1873 {
	static int H, W;
	static char[][] map;
	static int[] site;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String a = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = a.charAt(j);
					if (map[i][j] == '^' || map[i][j] == '>' || map[i][j] == '<' || map[i][j] == 'v') {
						int[] s = { i, j };
						site = s;
					}
				}
			}
			int k = Integer.parseInt(br.readLine());
			String m = br.readLine();
			for (int i = 0; i < k; i++) {
				if (m.charAt(i) == 'S') {
					shot(site[1], site[0], map[site[0]][site[1]]);
				} else {
					move(m.charAt(i));
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

	static void shot(int x, int y, char a) {
		if (a == '^') {
			int ny = y;
			while (ny > 0) {
				ny--;
				if (map[ny][x] == '*') {
					map[ny][x] = '.';
					break;
				} else if (map[ny][x] == '#') {
					break;
				}
			}
		} else if (a == '>') {
			int nx = x;
			while (nx < W - 1) {
				nx++;
				if (map[y][nx] == '*') {
					map[y][nx] = '.';
					break;
				} else if (map[y][nx] == '#') {
					break;
				}
			}

		} else if (a == '<') {
			int nx = x;
			while (nx > 0) {
				nx--;
				if (map[y][nx] == '*') {
					map[y][nx] = '.';
					break;
				} else if (map[y][nx] == '#') {
					break;
				}
			}
		} else if (a == 'v') {
			int ny = y;
			while (ny < H - 1) {
				ny++;
				if (map[ny][x] == '*') {
					map[ny][x] = '.';
					break;
				} else if (map[ny][x] == '#') {
					break;
				}
			}
		}
	}

	static void move(char a) {
		if (a == 'U') {
			map[site[0]][site[1]] = '^';
			if (site[0] > 0) {
				if (map[site[0] - 1][site[1]] == '.') {
					map[site[0]][site[1]] = '.';
					site[0]--;
					map[site[0]][site[1]] = '^';
				}
			}
		} else if (a == 'D') {
			map[site[0]][site[1]] = 'v';
			if (site[0] < H - 1) {
				if (map[site[0] + 1][site[1]] == '.') {
					map[site[0]][site[1]] = '.';
					site[0]++;
					map[site[0]][site[1]] = 'v';
				}
			}
		} else if (a == 'L') {
			map[site[0]][site[1]] = '<';
			if (site[1] > 0) {
				if (map[site[0]][site[1] - 1] == '.') {
					map[site[0]][site[1]] = '.';
					site[1]--;
					map[site[0]][site[1]] = '<';
				}
			}
		} else if (a == 'R') {
			map[site[0]][site[1]] = '>';
			if (site[1] < W - 1) {
				if (map[site[0]][site[1] + 1] == '.') {
					map[site[0]][site[1]] = '.';
					site[1]++;
					map[site[0]][site[1]] = '>';
				}
			}
		}
	}
}
