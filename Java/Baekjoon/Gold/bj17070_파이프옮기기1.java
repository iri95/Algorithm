package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17070_파이프옮기기1 {
	static int[][][] dp;
	static int[][] map;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N+1][N+1][3];
		for (int i = 1; i <= N; i++) {
			if(map[0][i]==1)break;
			dp[0][i][0] = 1;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				if(map[i][j] == 1) {
					dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = 0;
					continue;
				}
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
				if(map[i-1][j] == 1 || map[i][j-1] == 1) {
					dp[i][j][1] = 0;
				}else {
					dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				}
				dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
				
			}
		}
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
		
	}

}
