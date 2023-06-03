package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10164_격자상의경로 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		map[1][1] = 1;
		if(K == 0) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if(i == 1 && j == 1)continue;
					map[i][j] = map[i-1][j] + map[i][j-1];
				}
			}
		}else {
			int x = 0;
			int y = 0;
			if(K % M == 0) {
				x = M;
				y = K / M;
			}else {
				x = K % M ;
				y = K / M + 1;
			}
			for (int i = 1; i <= y; i++) {
				for (int j = 1; j <= x; j++) {
					if(i == 1 && j == 1)continue;
					map[i][j] = map[i-1][j] + map[i][j-1];
				}
			}
			for (int i = y; i <= N; i++) {
				for (int j = x; j <= M; j++) {
					map[i][j] = map[i-1][j] + map[i][j-1];
				}
			}
		}
		System.out.println(map[N][M]);

	}

}
