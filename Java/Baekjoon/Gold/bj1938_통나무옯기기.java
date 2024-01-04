package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class bj1938_통나무옯기기 {
	static int N;
	static char[][] map;
	static List<int[]> B, E;
	static int stateB, stateE; // 1일 경우 가로 0일 경우 세로
	static int[][][] resultMap; // 최소 이동 횟수 저장
	static boolean[][][] visit; // 가로일 경우 0, 세로일 경우 1
	static Queue<int[]> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		resultMap = new int[N][N][2];
		B = new ArrayList<>();
		E = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			int cntB = 0;
			int cntE = 0;
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'B') {
					cntB++;
					B.add(new int[] {i, j});
					if(cntB >1)stateB = 1;
				}else if(map[i][j] == 'E') {
					cntE++;
					E.add(new int[] {i, j});
					if(cntE >1)stateE = 1;
				}
			}
		}
		int[] b = {B.get(1)[0], B.get(1)[1], stateB};
		int[] e = new int[] {E.get(1)[0], E.get(1)[1], stateE};
		
		// [2]는 가로 세로 나눔 
		visit = new boolean[N][N][2];
		
		bfs(b);
		System.out.println(resultMap[e[0]][e[1]][e[2]]);
	}
	static void bfs(int[] b) {
		queue.offer(b);
		visit[b[0]][b[1]][b[2]] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- >0) {
				int[] p = queue.poll();
				right(new int[] {p[0], p[1], p[2]});
				left(new int[] {p[0], p[1], p[2]});
				down(new int[] {p[0], p[1], p[2]});
				up(new int[] {p[0], p[1], p[2]});
				turn(new int[] {p[0], p[1], p[2]});
			}
		}
	}
	
	static void right(int[] b) {
		int k = resultMap[b[0]][b[1]][b[2]];
		if(b[2] == 1) {
			if(b[1]+2 < N && map[b[0]][b[1]+2] != '1') {
				b[1]++;
				if(visit[b[0]][b[1]][b[2]])return;
				visit[b[0]][b[1]][b[2]] = true;
				resultMap[b[0]][b[1]][b[2]] = k+1;
				queue.offer(new int[] {b[0], b[1], b[2]});
			}
		}else {
			if(b[1] + 1 < N && map[b[0]-1][b[1] + 1] != '1' && map[b[0]][b[1] + 1] != '1' && map[b[0] + 1][b[1] + 1] != '1') {
				b[1]++;
				if(visit[b[0]][b[1]][b[2]])return;
				visit[b[0]][b[1]][b[2]] = true;
				resultMap[b[0]][b[1]][b[2]] = k+1;
				queue.offer(new int[] {b[0], b[1], b[2]});
			}
		}
	}
	
	static void left(int[] b) {
		int k = resultMap[b[0]][b[1]][b[2]];
		if(b[2] == 1) {
			if(b[1]-2 >= 0 && map[b[0]][b[1]-2] != '1') {
				b[1]--;
				if(visit[b[0]][b[1]][b[2]])return;
				visit[b[0]][b[1]][b[2]] = true;
				resultMap[b[0]][b[1]][b[2]] = k+1;
				queue.offer(new int[] {b[0], b[1], b[2]});
			}
		}else {
			if(b[1] - 1 >= 0 && map[b[0]-1][b[1] - 1] != '1' && map[b[0]][b[1] - 1] != '1' && map[b[0] + 1][b[1] - 1] != '1') {
				b[1]--;
				if(visit[b[0]][b[1]][b[2]])return;
				visit[b[0]][b[1]][b[2]] = true;
				resultMap[b[0]][b[1]][b[2]] = k+1;
				queue.offer(new int[] {b[0], b[1], b[2]});
			}
		}
	}
	
	static void down(int[] b) {
		int k = resultMap[b[0]][b[1]][b[2]];
		if(b[2] == 1) {
			if(b[0] + 1 < N && map[b[0]+1][b[1] - 1] != '1' && map[b[0]+1][b[1]] != '1' && map[b[0]+1][b[1] + 1] != '1') {
				b[0]++;
				if(visit[b[0]][b[1]][b[2]])return;
				visit[b[0]][b[1]][b[2]] = true;
				resultMap[b[0]][b[1]][b[2]] = k+1;
				queue.offer(new int[] {b[0], b[1], b[2]});
			}
		}else {
			if(b[0]+2 < N && map[b[0]+2][b[1]] != '1') {
				b[0]++;
				if(visit[b[0]][b[1]][b[2]])return;
				visit[b[0]][b[1]][b[2]] = true;
				resultMap[b[0]][b[1]][b[2]] = k+1;
				queue.offer(new int[] {b[0], b[1], b[2]});
			}
		}
	}
	
	static void up(int[] b) {
		int k = resultMap[b[0]][b[1]][b[2]];
		if(b[2] == 1) {
			if(b[0] - 1 >= 0 && map[b[0]-1][b[1] - 1] != '1' && map[b[0] - 1][b[1]] != '1' && map[b[0]- 1][b[1] + 1] != '1') {
				b[0]--;
				if(visit[b[0]][b[1]][b[2]])return;
				visit[b[0]][b[1]][b[2]] = true;
				resultMap[b[0]][b[1]][b[2]] = k+1;
				queue.offer(new int[] {b[0], b[1], b[2]});
			}
		}else {
			if(b[0]-2 >= 0 && map[b[0]-2][b[1]] != '1') {
				b[0]--;
				if(visit[b[0]][b[1]][b[2]])return;
				visit[b[0]][b[1]][b[2]] = true;
				resultMap[b[0]][b[1]][b[2]] = k+1;
				queue.offer(new int[] {b[0], b[1], b[2]});
			}
		}
	}
	static void turn(int[] b) {
		int k = resultMap[b[0]][b[1]][b[2]];
		if(b[2] == 1) {
			if(!turn(b[0],b[1]))return;
			b[2] = 0;
			if(visit[b[0]][b[1]][b[2]])return;
			visit[b[0]][b[1]][b[2]] = true;
			resultMap[b[0]][b[1]][b[2]] = k+1;
			queue.offer(new int[] {b[0], b[1], b[2]});
		}else {
			if(!turn(b[0],b[1]))return;
			b[2] = 1;
			if(visit[b[0]][b[1]][b[2]])return;
			visit[b[0]][b[1]][b[2]] = true;
			resultMap[b[0]][b[1]][b[2]] = k+1;
			queue.offer(new int[] {b[0], b[1], b[2]});
		}
	}
	static boolean turn(int y, int x) {
		if(y<1 || y >= N-1 || x < 1 || x >= N-1)return false;
		if(map[y-1][x-1] == '1' || map[y-1][x] == '1' || map[y-1][x+1] == '1' || map[y][x-1] == '1' || map[y][x+1] == '1' || map[y+1][x-1] == '1'|| map[y+1][x] == '1' || map[y+1][x+1] == '1')return false;
		else return true;
		
	}
}
