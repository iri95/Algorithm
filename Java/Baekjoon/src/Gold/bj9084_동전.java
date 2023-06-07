package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://propercoding.tistory.com/16 
public class bj9084_동전 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			long[] result = new long[10001];
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] list = new int[N];
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= M; j++) {
					if (j - list[i] > 0) {
						result[j] = result[j] + result[j - list[i]];
					} else if (j - list[i] == 0) {
						result[j]++;
					}
				}
			}
			System.out.println(result[M]);
		}

	}

}
