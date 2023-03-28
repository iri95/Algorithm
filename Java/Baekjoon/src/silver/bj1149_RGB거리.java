package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1149_RGB거리 {
	static int[][] dp;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n][3];
		map = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0] = map[0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp[i][0] = Integer.min(dp[i-1][1] + map[i][0], dp[i-1][2]+ map[i][0]);
				}else if(j==1) {
					dp[i][1] = Integer.min(dp[i-1][0] + map[i][1], dp[i-1][2]+ map[i][1]);
				}else if(j==2) {
					dp[i][2] = Integer.min(dp[i-1][0] + map[i][2], dp[i-1][1]+ map[i][2]);
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			result = Integer.min(dp[n-1][i], result);
		}
		System.out.println(result);

	}

}
