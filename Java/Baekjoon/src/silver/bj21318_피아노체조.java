package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj21318_피아노체조 {
	static int N, Q;
	static int[][] list;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new int[N+1][2];
		int b = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(b > a) {
			list[i-1][0] = list[i-2][0] + 1;
			list[i-1][1] = 1;
			}else {
				list[i-1][0] = list[i-2][0];
			}
			b = a;
		}
		list[N][0] = list[N-1][0];
		Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int fault = list[y][0] - list[x-1][0] - list[y][1];
			sb.append(fault + "\n");
		}
		System.out.println(sb);
	}

}
