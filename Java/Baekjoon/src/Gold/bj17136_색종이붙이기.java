package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17136_색종이붙이기 {
	static int[][] map;
	static int[] paper = { 0, 5, 5, 5, 5, 5 }; // 0 dummy;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		// 풀이
		ans = Integer.MAX_VALUE;
		
		dfs(0, 0, 0);
		
		if( ans == Integer.MAX_VALUE) ans = -1;
		
		System.out.println(ans);
	}
	
	static void dfs(int y, int x, int cnt) { // cnt 사용색종이 수
		// y, x 좌표부터 사용 가능한 크기의 색종이를 써 보고 다음 좌표로 이동해서 재귀호출
		// 사용한 크기의 색종이를 다시 떼어 내고 다른 색종이를 써보는 완탐 방식
		
		// 기저조건
		if( y == 9 && x > 9) {
			ans = Math.min(ans,  cnt);
			return;
		}
		
		// 가지치기 조건
		if( ans <= cnt ) return; // 더 가봤자 색종이를 더 쓰게 되므로 의미 X
		
		// 한 줄 개행이 필요한 경우
		if( x > 9) {
			y = y + 1;
			x = 0;
		}
		
		// 가능한 색종이를 모두 사용해 본다.
		if( map[y][x] == 1 ) {
			// 1 인 칸에 색종이를 1 ~ 5 를 붙여본다.
			for (int i = 1; i <= 5; i++) {
				if( paper[i] > 0 && isAttach(y, x, i)) {
					// 색종이 붙인다.
					attach(y, x, i, 0);
					
					// 해당 색종이 수를 --
					paper[i]--;
					
					// 재귀 호출을 그 다음 좌표로
					dfs(y, x + i, cnt + 1);
					
					// 원복
					// 색종이를 뗸다.
					attach(y, x, i, 1);
					// 해당 색종이 수를 ++
					paper[i]++;
					
					
				}
			}
		}else {
			dfs(y, x + 1, cnt); // 바로 오른쪽으로 한 칸 이동
		}
	}
	
	static void attach(int y, int x, int size, int num) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				map[i][j] = num; 
			}
		}
	}
	
	static boolean isAttach(int y, int x, int size) {
		// range
		if( y + size >  10 || x + size > 10) return false;
		
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if( map[i][j] != 1) return false; // size 영역안에 0 이 있으면 실패
			}
		}
		return true;
	}
}









