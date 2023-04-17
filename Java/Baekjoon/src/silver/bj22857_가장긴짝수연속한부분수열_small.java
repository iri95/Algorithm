package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj22857_가장긴짝수연속한부분수열_small {
	static int N, K, odd, max;
	static boolean[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		odd = 0;
		max = Integer.MIN_VALUE;
		list = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if(Integer.parseInt(st.nextToken()) % 2 == 0) {
				list[i] = true;
			}
			if(!list[i]) odd++;
		}
		int cnt = 0;
		if(odd - K <= 0)System.out.println(N-odd);
		else {
			for (int i = 0; i < N - K; i++) {
				int kCnt = K;
				cnt = 0;
				for (int j = i; j < N; j++) {
					if(kCnt < 0)break;
					if(!list[j])kCnt--;
					else {
						cnt++;
					}
				}
				max = Integer.max(max, cnt);
			}
			System.out.println(max);
		}
		
	}

}
