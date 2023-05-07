package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1722_순열의순서 {
	static int N, Q;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] pac = new long[21];
		pac[0] = 1;
		for (int i = 1; i < 21; i++) {
			pac[i] = pac[i-1] * i;
		}
		N = Integer.parseInt(br.readLine());
		select = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Q = Integer.parseInt(st.nextToken());
		switch(Q) {
		case 1:
			long n = Long.parseLong(st.nextToken())-1;
			while(N-- > 0) {
				long a = 0;
				if(N == 0) {
					a = n;
				}else {
					a = n/pac[N];
				}
				int k = 0;
				for (int i = 1; i < select.length; i++) {
					if(select[i])continue;
					if(k == a) {
						sb.append(i + " ");
						select[i] = true;
						break;
					}
					k++;
				}
				n %= pac[N];
			}
			System.out.println(sb);
			break;
		case 2:
			int[] list = new int[N];
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			long result = 0;
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 1; j < select.length; j++) {
					if(select[j])continue;
					cnt++;
					if(list[i] == j) {
						result+= (cnt-1) * pac[N-1-i];
						select[j] = true;
						break;
					}
				}
			}
			System.out.println(result+1);
			break;
		}
		

	}

}
