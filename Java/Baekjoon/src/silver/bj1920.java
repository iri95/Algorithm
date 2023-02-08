package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1920 {
	static int N, M;
	static int[] A, B;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		for (int m : B) {
			int l = 0;
			int r = N-1;
			int count = 0;
			while(l<=r) {
				int a = (l+r)/2;
				if(A[a] == m) {
					count = 1;
					break;
				}
				if(A[a] < m) {
					l = a + 1;
				}else {
					r = a -1;
				}
				
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}

}
