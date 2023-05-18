package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16234_인구이동 {
	static int N, r, c, L, R;
	static int[][] A;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<int[]> vQueue = new ArrayDeque<>();
	static boolean[][] visit;
	static boolean did = true;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		while (did) {
			did = false;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j])bfs(new int[] {i, j});
				}
			}
			if(!did)break;
			count++;
		}
		System.out.println(count);
	}

	static void bfs(int[] a) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(a);
		vQueue.offer(a);
		int sum = 0;
		int cnt = 0;
		visit[a[0]][a[1]] = true;
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int k = A[p[0]][p[1]];
			sum += k;
			cnt++;
			for (int i = 0; i < 4; i++) {
				int ny = p[0] + dy[i];
				int nx = p[1] + dx[i];
				if (ny >= N || ny < 0 || nx < 0 || nx >= N || visit[ny][nx] || (int)Math.abs(k - A[ny][nx]) > R || (int)Math.abs(k - A[ny][nx]) < L)
					continue;
				visit[ny][nx] = true;
				vQueue.offer(new int[] {ny, nx});
				queue.offer(new int[] {ny, nx});
				did = true;
			}
		}
		int result = sum / cnt;
		while(!vQueue.isEmpty()) {
			int[] p = vQueue.poll();
			A[p[0]][p[1]] = result;
		}
	}
}
