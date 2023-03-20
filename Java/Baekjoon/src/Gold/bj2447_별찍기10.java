package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2447_별찍기10 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[][] map = func(N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==null)sb.append(" ");
				else sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static String[][] func(int a) {
		String[][] arr = new String[a][a];
		if (a == 3) {
			for (int i = 0; i < 9; i++) {
				if(i==4)continue;
				arr[i/3][i%3] = "*";
			}			
			return arr;
		}
		int x = a/3; // ~ + a/3-1
		String[][] temp = func(x);
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				if(x <= i && i < 2 * x && x <= j && j < 2 * x)continue;
				arr[i][j] = temp[i%x][j%x];
			}
		}
		return arr;
	}
}
