package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2960 {
	static int N, K;
	static int[] N_list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		N_list = new int[N + 1];
		int count = 0;
		int result = 0;
		for (int i = 0; i < N + 1; i++) {
			N_list[i] = i;
		}
		for (int i = 2; i < N + 1; i++) {
			for (int j = 1; i * j < N + 1; j++) {
				if (N_list[i * j] == 0) {
					continue;
				} else {
					N_list[i * j] = 0;
					count++;
					if (count == K) {
						result = i * j;
						break;
					}
				}
			}
			if (count == K)
				break;
		}
		System.out.println(result);
	}

}
