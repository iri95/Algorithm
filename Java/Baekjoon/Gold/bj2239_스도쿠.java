package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj2239_스도쿠 {

	static int[][] arr;
	static ArrayList<int[]> list = new ArrayList<>(); 
	static boolean result = false; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(temp.substring(j, j + 1));
				if (arr[i][j] == 0)
					list.add(new int[] {i, j}); 
			}
		}
		dfs(0);

	}
	private static void dfs(int n) {
		if (n == list.size()) { 
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					sb.append(arr[i][j]);
				sb.append("\n");
			}
			System.out.print(sb);
			result = true;
			return;
		}

		int[] temp = list.get(n);
		for (int i = 1; i < 10; i++) {

			boolean empty = true;
			
			for (int p = 0; p < 9; p++)
				if (arr[temp[0]][p] == i)
					empty = false;
			if (!empty)
				continue;
			
			for (int p = 0; p < 9; p++)
				if (arr[p][temp[1]] == i)
					empty = false;
			if (!empty)
				continue;
			
			for (int p = temp[0] / 3 * 3; p < (temp[0] / 3 + 1) * 3; p++) {
				for (int q = temp[1] / 3 * 3; q < (temp[1] / 3 + 1) * 3; q++)
					if (arr[p][q] == i)
						empty = false;
			}
			if (!empty)
				continue;

			arr[temp[0]][temp[1]] = i; 
			dfs(n + 1); 
			if (result)
				break; 
			arr[temp[0]][temp[1]] = 0;
		}
		return;
	}
}