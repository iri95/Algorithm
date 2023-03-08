package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2468_안전영역 {
	static int N, maxCnt, max;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		max = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > max) {
					max = map[i][j];
				}
			}
		}
		int cnt;
		for (int i = 0; i < max; i++) {
			cnt = 0;
			visit = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(map[j][j2] <= i || visit[j][j2])continue;
					dfs(j,j2,i);
					cnt++;
				}
			}
			maxCnt = Math.max(cnt, maxCnt);
		}
		System.out.println(maxCnt);
		
	}
	static void dfs(int y, int x, int dep) {
		if(visit[y][x] || map[y][x] <= dep)return;
		if(map[y][x] > dep)visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny <0 || ny >=N || nx < 0 || nx >=N)continue;
			dfs(ny,nx,dep);
			
		}
	}

}
