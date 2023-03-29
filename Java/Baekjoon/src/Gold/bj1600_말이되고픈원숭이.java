package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1600_말이되고픈원숭이 {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit;

	// 4방 delta
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	// 8방 delta
	static int[] hdx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] hdy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	// bfs Node
	static Queue<Node> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visit = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(); // 도착지저에 도달하게 되면 출력

	}

	static void bfs() {
		Node n = new Node(0, 0, K, 0);
		queue.offer(n);

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			// 목표 도달 확인
			if (node.y == H - 1 && node.x == W - 1) {
				System.out.println(node.d);
				return;
			}

			// 탐색 1 - 원숭이로 이동 4방
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];

				// range, visit...
				if (nx < 0 || nx >= W || ny < 0 || ny >= H || map[ny][nx] == 1 || visit[ny][nx][node.k])
					continue;
				visit[ny][nx][node.k] = true;
				queue.offer(new Node(ny, nx, node.k, node.d + 1)); // k 는 그대로, d는 증가
			}
			// 탐색 2 - 말로 이동 8방 <= K 조건을 따진다.
			if (node.k == 0)
				continue; // 이미 k 소진
			for (int i = 0; i < 8; i++) {
				int ny = node.y + hdy[i];
				int nx = node.x + hdx[i];

				// range, visit...
				// visit 주의 : k를 한 개 소진하고 갈 것이라 - 1로 계산
				if (nx < 0 || nx >= W || ny < 0 || ny >= H || map[ny][nx] == 1 || visit[ny][nx][node.k - 1])
					continue;
				visit[ny][nx][node.k - 1] = true;
				queue.offer(new Node(ny, nx, node.k - 1, node.d + 1)); // k 는 그대로, d는 증가
			}
		}
		System.out.println(-1);
	}

	static class Node {
		int y, x, k, d;

		Node(int y, int x, int k, int d) {
			this.y = y;
			this.x = x;
			this.k = k;
			this.d = d;
		}
	}
}
