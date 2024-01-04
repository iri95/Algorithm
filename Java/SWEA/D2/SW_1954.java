package D2;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1954 {
	static int N, T;
	static int[][] N_list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			N_list = new int[N][N];
			int a = 0;
			int b = 0;
			int count = 2;
			N_list[a][b] = 1;
			while (count <= N * N) {
				if (a == 0 && b != N - 1) {
					N_list[a][++b] = count++;

				} else if ((b == N - 1 && a != N - 1)) {
					N_list[++a][b] = count++;

				} else if ((a == N - 1 && b != 0)) {
					N_list[a][--b] = count++;

				} else if ((b == 0 && a != 0 && N_list[a - 1][b] == 0)) {
					N_list[--a][b] = count++;

				} else if (N_list[a][b + 1] == 0) {
					N_list[a][++b] = count++;

				} else if (N_list[a + 1][b] == 0) {
					N_list[++a][b] = count++;

				} else if (N_list[a][b - 1] == 0) {
					N_list[a][--b] = count++;

				} else if (N_list[a - 1][b] == 0) {
					N_list[--a][b] = count++;

				}
			}
			sb.append("#" + t + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(N_list[i][j]+ " ");
				}
				sb.append("\n");
			}
			
			System.out.print(sb);
		}
	}
}
