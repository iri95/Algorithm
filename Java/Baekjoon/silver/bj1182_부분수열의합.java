package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1182_부분수열의합 {
	static int N, S, result;
	static int[] list;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		list = new int[N];
		select = new boolean[N];
		result = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			if (list[i] == S)
				result++;
		}
		Arrays.sort(list);
		subset(0);
		System.out.println(result);
	}

	static void subset(int tgtIdx) {
		if (tgtIdx == N) {
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					cnt++;
					sum += list[i];
				}
			}
			if (cnt < 2)
				return;
			if (sum == S)
				result++;
			return;
		}
		
		select[tgtIdx] = true;
		subset(tgtIdx + 1);
		select[tgtIdx] = false;
		subset(tgtIdx + 1);
	}
}
