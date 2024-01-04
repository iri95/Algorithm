package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4485_녹색옷입은애가젤다지 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				System.out.println(sb);
				return;
			}
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] result = new int[N][N];
			int k = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				Arrays.fill(result[i], k);
			}
			result[0][0] = map[0][0];
			Queue<int[]> queue = new ArrayDeque<>();
			int[] start = {0, 0};
			queue.offer(start);
			while(!queue.isEmpty()) {
				int[] p = queue.poll();
				
				for (int i= 0; i < 4; i++) {
					int nx = p[1] + dx[i];
					int ny = p[0] + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || result[ny][nx] <= result[p[0]][p[1]]+ map[ny][nx] )continue;
					result[ny][nx] = result[p[0]][p[1]]+ map[ny][nx];
					int[] np = {ny, nx};
					queue.offer(np);
				}
				
			}
			
			sb.append("Problem " + t + ": " + result[N-1][N-1] + "\n");
			t++;
		}
	}

}
