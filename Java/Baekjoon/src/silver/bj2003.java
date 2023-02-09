package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2003 {
	static int N, M;
	static int[] A, Asum;
	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N+1];
		Asum = new int[N+1];
		int count = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (i == 1) {
				Asum[i] = A[i];
			} else {
				Asum[i] = Asum[i - 1] + A[i];
			}

		}
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < N + 1; j++) {
				if(M == Asum[j]-Asum[i]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
