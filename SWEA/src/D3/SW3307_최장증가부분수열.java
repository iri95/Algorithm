package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SW3307_최장증가부분수열 {
	static int[] input;
	static int N, len;
	static int[] LIS;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			input = new int[N];
			LIS = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			len = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				
				for (int j = 0; j < i; j++) {
					if( input[j] < input[i])LIS[i] = Math.max(LIS[i],  LIS[j] + 1);
				}
				len = Math.max(LIS[i], len);
			}
			
			sb.append("#" + t + " " + len + "\n");
			
		}
		System.out.println(sb);
		
		
	}
}
