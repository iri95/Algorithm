package D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW6782_현주가좋아하는제곱근놀이 {
	static long N;
	static int T;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Long.parseLong(br.readLine());
			int cnt = 0;
			while(N != 2) {
				Double sqrtN = Math.sqrt(N);
				if(sqrtN != sqrtN.longValue()) {
					long k = (long) Math.pow((sqrtN.longValue()+ 1),2);
					cnt += k - N;
					N = ((Double)Math.sqrt(k)).longValue();
					cnt += 1;
				}else {
					N = sqrtN.longValue();
					cnt += 1;
				}
			}
			sb.append("#" + t + " " +cnt+ "\n");
		}
		System.out.println(sb);
	}
	
}

