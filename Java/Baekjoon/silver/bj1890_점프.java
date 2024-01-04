package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1890_점프 {
	static int N;
	static long[][] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = new long[N][N];
		boolean[][] visit = new boolean[N][N];
		visit[0][0] = true;
		result[0][0] = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				if(k == 0)continue;
				int rp = k + j;
				int dp = k + i;
				if(!visit[i][j])continue;
				if (rp < N) {
					if (result[i][rp] == 0) {
						result[i][rp] = result[i][j];
					} else {
						result[i][rp] += result[i][j];
					}
					visit[i][rp] = true;
				}
				if (dp < N) {
					if (result[dp][j] == 0) {
						result[dp][j] = result[i][j];
					} else {
						result[dp][j] += result[i][j];
					}
					visit[dp][j] = true;
				}
			}
		}
		System.out.println(result[N - 1][N - 1]);
	}
}
