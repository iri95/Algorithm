package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1992 {
	static int[][] list;
	static int n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new int[n][n];
		for (int i = 0; i < n; i++) {
			String st = br.readLine();
			for (int j = 0; j < n; j++) {
				list[i][j] = Character.getNumericValue(st.charAt(j));
			}
		}
		cut(0,0,n);
		System.out.println(sb);
	}
	static void cut(int r, int c, int size) {
		int sum = 0;
		for (int i = r; i < r + size ; i++) {
			for (int j = c; j < c + size; j++) {
				sum += list[i][j];
			}
		}
		if(sum == size*size) {
			sb.append("1");
		}else if(sum == 0) {
			sb.append("0");
		}else {
			sb.append("(");
			int half = size/2;
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r + half, c, half);
			cut(r + half, c + half, half);
			sb.append(")");
		}
	}

}
