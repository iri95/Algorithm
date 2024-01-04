package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11053_가장긴증가하는부분수열 {
	static int N;
	static int[] A, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(result, 1);
		int max = 1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(A[i]>A[j]) {
					result[i] = Math.max(result[i], result[j]+1);
				}
				max = Math.max(result[i], max);
			}
		}
		System.out.println(max);
	}
}
