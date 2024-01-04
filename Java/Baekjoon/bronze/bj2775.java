package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2775 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] a = new int[15][15];
		for (int i = 1; i < 15; i++) {
			a[0][i] = i;
		}
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				a[i][j] = a[i-1][j] + a[i][j-1];
			}
		}
		int x, y;
		for (int t = 0; t < T; t++) {
			x = Integer.parseInt(br.readLine());
			y = Integer.parseInt(br.readLine());
			sb.append(a[x][y] + "\n");
		}
		System.out.println(sb);
	}

}
