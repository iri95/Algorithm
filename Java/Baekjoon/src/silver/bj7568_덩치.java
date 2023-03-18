package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj7568_덩치 {
	static int[][] member;
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		member = new int[N][3];
		for (int i = 0; i < N; i++) {
			Arrays.fill(member[i], 1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			member[i][0] = Integer.parseInt(st.nextToken());
			member[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i == j)continue;
				if(member[i][0] < member[j][0] && member[i][1] < member[j][1]) {
					member[i][2]++;
				}
			}
			sb.append(member[i][2]+ " ");
		}
		System.out.println(sb);
	}

}
