package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1978 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		int[] prime = new int[1001];
		prime[1] = prime[0] = 0;
		
		for(int i = 2; i < 1001; i++) {
			prime[i] = i;
		}
		for(int i = 2; i < 33; i++) {
			if(prime[i] == 0)continue;
			for(int j = i+1; j < 1001; j++) {
				if(prime[j]%i == 0) prime[j] = 0;
			}
		}
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < prime.length; j++) {
				if(prime[j]==0)continue;
				if(a == prime[j]) {
					count++;
					break;
				}
			}
			
		}
		System.out.println(count);
	}

}
