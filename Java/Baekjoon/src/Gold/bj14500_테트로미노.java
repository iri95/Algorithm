package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14500_테트로미노 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(j + 3 < M) {
					// 파란색
					result = Math.max(result, map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3]);
				}
				if(i + 3 < N) {
					// 파란색 회전
					result = Math.max(result, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j]);
				}
				
				if(i + 1 < N && j + 1 < M) {
					// 노란색 정사각형
					result = Math.max(result, map[i][j] + map[i][j+1] + map[i + 1][j] + map[i + 1][j + 1]);
				}
				
				if(i + 2 < N && j + 1 < M) {
					// 주황색 대칭 및 회전 가로2 세로 3
					result = Math.max(result, map[i][j] + map[i+1][j] + map[i + 2][j] + map[i + 2][j + 1]);
					result = Math.max(result, map[i][j] + map[i][j+1] + map[i + 1][j+1] + map[i + 2][j + 1]);
					result = Math.max(result, map[i][j+1] + map[i+1][j+1] + map[i + 2][j+1] + map[i+2][j]);
					result = Math.max(result, map[i][j] + map[i][j+1] + map[i + 1][j] + map[i + 2][j]);
				}
				
				if(i+1 < N && j + 2 < M) {
					// 주황색 대칭 및 회전 가로 3 세로 2
					result = Math.max(result, map[i][j] + map[i][j+1] + map[i][j + 2] + map[i + 1][j]);
					result = Math.max(result, map[i][j] + map[i][j+1] + map[i][j + 2] + map[i + 1][j + 2]);
					result = Math.max(result, map[i+1][j] + map[i+1][j+1] + map[i+1][j + 2] + map[i][j]);
					result = Math.max(result, map[i+1][j] + map[i+1][j+1] + map[i+1][j + 2] + map[i][j+2]);
					
					// 초록색 대칭 및 회전 가로 3 세로 2
					result = Math.max(result, map[i][j+1] + map[i][j+2] + map[i+1][j] + map[i + 1][j+1]);
					result = Math.max(result, map[i][j] + map[i][j+1] + map[i+1][j + 1] + map[i + 1][j+2]);
				}
				
				if(i + 2 < N && j + 1 < M) {
					// 초록색 대칭 및 회전 가로 2 세로 3
					result = Math.max(result, map[i][j] + map[i+1][j] + map[i + 1][j + 1] + map[i + 2][j + 1]);
					result = Math.max(result, map[i][j+1] + map[i+1][j] + map[i + 1][j + 1] + map[i + 2][j]);
				}
				
				if(i + 1 < N && j + 2 < M) {
					// 분홍색 대칭 및 회전 가로 3 세로 2
					result = Math.max(result, map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1]);
					result = Math.max(result, map[i+1][j] + map[i+1][j + 1] + map[i+1][j + 2] + map[i][j + 1]);
				}
				
				if(i + 2 < N && j + 1 < M) {
					// 분홍색 대칭 및 회전 가로 2 세로 3
					result = Math.max(result, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j + 1]);
					result = Math.max(result, map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j]);
				}
				
			}
		}
		System.out.println(result);
	}

}
