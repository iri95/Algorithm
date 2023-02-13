

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1210_my {
	static int[][] data;
	static int T, end_num, start_num, next_ynum, next_xnum;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 10; t++) {
			T = Integer.parseInt(br.readLine());
			data = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
					if (i == 99 && data[i][j] == 2) {
						end_num = j;
					}
				}
			}
			next_ynum = 98;
			next_xnum = end_num;
			while (next_ynum != 0) {
				if (next_xnum != 99 && data[next_ynum][next_xnum + 1] == 1) {
					while (next_xnum != 99 &&data[next_ynum][next_xnum + 1] == 1) {
						next_xnum += 1;
					}
					next_ynum -= 1;
				} else if (next_xnum != 0 && data[next_ynum][next_xnum - 1] == 1) {
					while (next_xnum != 0 && data[next_ynum][next_xnum - 1] == 1) {
							next_xnum -= 1;
					}
					next_ynum -= 1;
				} else if (data[next_ynum - 1][next_xnum] == 1) {
					next_ynum -= 1;
				}
			}

			start_num = next_xnum;
			System.out.println("#" + T + " " + start_num);
		}
	}
}
