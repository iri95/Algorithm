package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9205_맥주마시면서걸어가기 {
	
	static int T, N, V;
	static int BIG = 101 * 32767 * 2;
	static int[][] input, matrix;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			V = N + 2; // 편의점, 집, 공연장
			input = new int[V][2]; // 먼저 입력받아서 좌표를 이용해서 거리를 계산한 후, 1000m (맥주 1박스로 웃으면서 이동) 거리 이내이면 연결
			matrix = new int[V][V];
			
			// 입력처리
			for (int i = 0; i < V; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 입력 => matrix 구성
			for (int i = 0; i < V; i++) {
				int vy = input[i][0];
				int vx = input[i][1];
				
				for (int j = 0; j < V; j++) {
					if( i == j) continue;
					
					int ty = input[j][0];
					int tx = input[j][1];
					int dis = Math.abs(ty - vy) + Math.abs(tx - vx); // 맨하틴 거리로 계산
					
					if( dis <= 1000) matrix[i][j] = dis; // dis 비용으로 연결
					else matrix[i][j] = BIG;
				}
			}
			
			// 플로이드 워셜 적용
			for (int k = 0; k < V; k++) { // 경유지
				for (int i = 0; i < V; i++) { // 출발지
					if(i == k) continue;
					for (int j = 0; j < V; j++) { // 도착지
						if(j == k || j == i)continue;
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
				}
			}
			
			
			// (집 : 0 ) -> (공연장 : V-1) matrix[0][V-1] BIG 이 아니면 happy or sad
			System.out.println(matrix[0][V-1] != 0 && matrix[0][V-1] < BIG ? "happy" : "sad");
		}	
	}
}
