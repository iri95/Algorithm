package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간초과, 자료구조 공부 후 다시 풀어보기
public class bj_2015_수들의합4 {
	static int N, K, result;
	static int[] A;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken()) + A[i-1];
		}
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if(A[j] - A[i-1] == K)result++;
			}
		}
		System.out.println(result);
	}
}
