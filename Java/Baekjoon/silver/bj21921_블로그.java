package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj21921_블로그 {
	static int N, X;
	static int[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		list = new int[N];
		st = new StringTokenizer(br.readLine());
		list[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			list[i] = list[i - 1] + Integer.parseInt(st.nextToken());
		}
		int max = list[X - 1];
		int day = 1;
		for (int i = 1; i <= N - X; i++) {
			int sum = list[i + X - 1] - list[i - 1];
			if (max < sum) {
				day = 1;
				max = sum;
			} else if (max == sum) {
				day++;
			}
		}
		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(day);
		}

	}

}
