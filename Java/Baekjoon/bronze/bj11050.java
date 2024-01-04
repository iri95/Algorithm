package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11050 {
	static int N, K, up, down;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		up = 1;
		down = 1;
		for(int i = 0; i < K ; i++) {
			up *= (N-i);
			down *= (i+1);
		}
		sb.append(up/down);
		System.out.println(sb);
	}

}
