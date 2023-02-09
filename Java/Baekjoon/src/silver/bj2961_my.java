package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2961_my {
	static int N, min;
	static int[] S,B;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		select = new boolean[N];
		S = new int[N];
		B = new int[N];

		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		cook(0,1,0);
		System.out.println(min);
	}
	static void cook(int srcIdx, int mul, int sum) {
		int count = 0 ;
		if(srcIdx == N) {
			for(int i = 0; i < N; i++) {
				if(select[i]) {
					mul *= S[i];
					sum += B[i];
				}else {
					count++;
				}
			}
			if(min>Math.abs(mul-sum)&& count != N) min = Math.abs(mul-sum); 
			count =0;
			return;
		}
		select[srcIdx] = true;
		cook(srcIdx + 1,mul, sum);
		
		select[srcIdx] = false;
		cook(srcIdx + 1,mul, sum);
		
	}

}
