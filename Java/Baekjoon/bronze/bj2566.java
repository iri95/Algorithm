package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2566 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int max = Integer.MIN_VALUE;
		int x = 0, y = 0;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (max < a) {
					max = a;
					x = i;
					y = j;
				}
			}
		}
		sb.append(max+"\n");
		sb.append((x+1) + " " + (y+1));
		System.out.println(sb);
	}
	

}
