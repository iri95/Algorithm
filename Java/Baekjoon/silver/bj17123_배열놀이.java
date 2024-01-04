package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17123_배열놀이 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] list = new int[N+2][N+2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					list[i][j] = Integer.parseInt(st.nextToken()) - list[i-1][j-1] + list[i-1][j] + list[i][j-1];
				}
			}
			for (int i = N; i >= 1; i--) {
				list[i][N+1] = list[i][N] - list[i-1][N];
				list[N+1][i] = list[N][i] - list[N][i-1];
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int r1 = Integer.parseInt(st.nextToken());
				int c1 = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				for (int j = r1; j <= r2; j++) {
					list[j][N+1] += v * (c2 - c1 + 1);
				}
				for (int j = c1; j <= c2; j++) {
					list[N+1][j] += v * (r2 - r1 + 1);
				}
			}
			for (int i = 1; i <= N; i++) {
				sb.append(list[i][N+1] + " ");
			}
			sb.append("\n");
			for (int i = 1; i <= N; i++) {
				sb.append(list[N+1][i] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
