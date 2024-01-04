package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj13416 {
	static int N, sum;
	static int[] list = new int[4];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list[0] = Integer.parseInt(st.nextToken());
				list[1] = Integer.parseInt(st.nextToken());
				list[2] = Integer.parseInt(st.nextToken());
				list[3] = 0;
				Arrays.sort(list);
				sum += list[3];
			}
			sb.append(sum + "\n");
			sum =0;
		}
		System.out.println(sb);
	}

}
