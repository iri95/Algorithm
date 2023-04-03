package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11047_동전0 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		while(K > 0) {
			for (int i = N-1; i >= 0; i--) {
				while(K >= A[i]) {
					K = K - A[i];
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}

}
