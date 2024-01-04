package D2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2001 {
	static int N, M, T, max;
	static int[][] N_list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			N_list = new int[N][N];
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					N_list[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int sum = 0;
					for (int n = i; n < i + M; n++) {
						for (int m = j; m < j + M; m++) {
							sum += N_list[n][m];
							if (max < sum)
								max = sum;
						}
					}
				}
			}
			sb.append("#" + t + " " + max+"\n");
		}
		System.out.println(sb);
	}
}
