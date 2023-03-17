package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1018_체스판다시칠하기 {
	static int N, M, cnt;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		cnt = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'B') {
					map[i][j] = true;
				} else {
					map[i][j] = false;
				}
			}
		}
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int count = 0;
				int count2 = 0;
				boolean tf = map[i][j];
				boolean tf2 = map[i][j];
				for (int k = i; k < i + 8; k++) {
					for (int k2 = j; k2 < j + 8; k2++) {
						if(tf == map[k][k2])count++;
						if(tf2 != map[k][k2])count2++;
						if(tf == true)tf = false;
						else tf = true;
						if(tf2 == true)tf2 = false;
						else tf2 = true;
					}
					if(tf == true)tf = false;
					else tf = true;
					if(tf2 == true)tf2 = false;
					else tf2 = true;
				}
				count = Math.min(64 - count, 64 - count2);
				cnt = Math.min(count, cnt);
			}

		}
		System.out.println(cnt);

	}
}
