package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2545_팬케익먹기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			long[] list = new long[3];
			for (int j = 0; j < 3; j++) {
				list[j] = Long.parseLong(st.nextToken()); 
			}
			Arrays.sort(list);
			long d = Long.parseLong(st.nextToken());
			long sum = list[0] + list[1] + list[2] - d;
			long temp = Math.min(sum/3, list[0]);
			long a1 = temp;
			sum -= temp;
			temp = Math.min(sum/2, list[1]);
			sb.append(a1*temp*(sum-temp) + "\n");
		}
		System.out.println(sb);

	}

}
