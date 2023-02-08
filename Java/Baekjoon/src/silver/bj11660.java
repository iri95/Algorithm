package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11660 {
	static int N, M;
	static int[][] N_list,Nsum_list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		N_list = new int[N][N];
		Nsum_list = new int[N+1][N+1];
		for(int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0; x < N; x++) {
				N_list[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				Nsum_list[i][j] = Nsum_list[i][j-1] + N_list[i-1][j-1];
			}
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				Nsum_list[i][j] = Nsum_list[i-1][j] + Nsum_list[i][j];
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			result(Nsum_list, x1,y1, x2, y2);
		}
		System.out.println(sb);
		
		
	}
	static void result(int[][] arr,int x1,int y1,int x2,int y2) {
		sb.append(Nsum_list[x2][y2] - Nsum_list[x2][y1-1] - Nsum_list[x1-1][y2] + Nsum_list[x1-1][y1-1]).append("\n");
	}

}
