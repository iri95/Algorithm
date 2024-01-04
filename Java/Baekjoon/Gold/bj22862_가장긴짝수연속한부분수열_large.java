package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-22862-%EC%9E%90%EB%B0%94-java-%EA%B0%80%EC%9E%A5-%EA%B8%B4-%EC%A7%9D%EC%88%98-%EC%97%B0%EC%86%8D%ED%95%9C-%EB%B6%80%EB%B6%84-%EC%88%98%EC%97%B4-large 
public class bj22862_가장긴짝수연속한부분수열_large {
	static int N, K, odd, max;
	static boolean[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE;
		list = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(st.nextToken()) % 2 == 1) {
				list[i] = true;
			}
		}
		int cnt = 0;
		int p = 0;
		int start = 0;
		while (p <= N - 1) {
			if (cnt < K) {
				if (list[p]) {
					cnt++;
				}
				p++;
				max = Math.max(max, p - start - cnt);
			} else if (!list[p]) {
				p++;
				max = Math.max(max, p - start - cnt);
			} else if (cnt == K && list[p]) {
				if (list[start]) {
					cnt--;
				}
				start++;
			}
		}
		System.out.println(max);

	}

}
