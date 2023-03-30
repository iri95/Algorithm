package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14502_연구소 {
	static int N, M, max;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map, temp, tgt;
	static List<int[]> posi2 = new ArrayList<>();
	static Queue<int[]> queue = new ArrayDeque<>();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		tgt = new int[3][2];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
				if(map[i][j] == 2) {
					int[] a = {i, j};
					posi2.add(a);
				}
			}
		}
		comb(0, 0);
		System.out.println(max);
		

	}
	// bfs
	static void bfs() {
		while(!queue.isEmpty()) {
			int[] b = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = b[1] + dx[i];
				int ny = b[0] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= M || ny >= N || temp[ny][nx] == 1 || temp[ny][nx] == 2)continue;
				temp[ny][nx] = 2;
				int[] c = {ny, nx};
				queue.offer(c);
			}
		}	
	}
	
	
	// comb
	static void comb(int tgtIdx, int a) {
		if(tgtIdx == 3) {
			for (int[] i : posi2) {
				queue.offer(i);
			}
			for (int[] i : tgt) {
				temp[i[0]][i[1]] = 1;
			}
			
			bfs();
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(temp[i][j] == 0)cnt++;
				}
			}
			max = Math.max(max, cnt);
			invalid();
			return;
		}
		for (int i = a; i < N * M; i++) {
			if(map[i/M][i%M] == 2 || map[i/M][i%M] == 1 )continue;
			int[] d = {i/M, i%M};
			tgt[tgtIdx] = d;
			comb(tgtIdx + 1, i + 1);
			
		}
	}
	
	
	// temp 초기화
	static void invalid() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}
}
