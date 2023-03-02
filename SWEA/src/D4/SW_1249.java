package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs 문제
// 상하좌우를 살펴 해당 위치에 저장된 값보다 적은 값으로 갈수있을 경우 큐에 저장

public class SW_1249 {
	static int N;
	static int[][] map;
	static int[][] ans;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String st = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Character.getNumericValue(st.charAt(j));
				}
			}
			int inf = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				Arrays.fill(ans[i], inf);
			}
			ans[0][0] = 0;
			
			bfs(0, 0);
			sb.append(ans[N-1][N-1]+"\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int y , int x) {
		Queue<int[]> pos = new ArrayDeque<>();
		int[] a = {y, x};
		
		pos.offer(a);
		while(!pos.isEmpty()) {
			int[] p = pos.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = p[0] + dy[i];
				int nx = p[1] + dx[i];
				if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if(ans[ny][nx] > ans[p[0]][p[1]] + map[ny][nx]) {
					ans[ny][nx] = ans[p[0]][p[1]] + map[ny][nx];
					int[] k = {ny, nx};
					pos.offer(k);
				}
			}
			
			
		}
	}
	
	
}
