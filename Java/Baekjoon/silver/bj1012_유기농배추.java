package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1012_유기농배추 {
	static int[][] map;
	static boolean[][] select;
	static int M,N,K, cnt;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			select = new boolean[N][M];
			cnt = 0;
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(map[j][j2]==1 && !select[j][j2]) {
						cnt++;
						dfs(j, j2);
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
	static void dfs(int y, int x) {
		if(select[y][x] || map[y][x] == 0)return;
		select[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny <0 || ny >= N || nx < 0 || nx >= M)continue;
			dfs(ny,nx);
		}
		
	}

}
