package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 시간초과
public class bj2447_별찍기10 {
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		map = func(N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);

	}

	static char[][] func(int a) {
		char[][] arr = new char[a][a];
		if (a == 1) {
			arr[0][0] = '*';
			return arr;
		}
		int y = a/3;
		int x = a/3; // ~ + a/3-1
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				if(y <= i && i < y + a/3 && x <= j && j < x + a/3)continue;
				arr[i][j] = func(a/3)[i%(a/3)][j%(a/3)];
			}
		}
		return arr;
	}
}
