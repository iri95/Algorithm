package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_14510 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			int N = Integer.parseInt(br.readLine());
			int[] treeH = new int[N];
			int max = Integer.MIN_VALUE;
			int sub = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				treeH[i] = Integer.parseInt(st.nextToken()); 
				if(treeH[i] > max) {
					max = treeH[i];
				}
			}
			int day = 0;
			int odd = 0; // 홀수
			int even = 0; // 짝수
			for (int i = 0; i < N; i++) {
				sub = max - treeH[i];
				odd += sub%2;
				even += sub/2;
			}
			int subnum = Math.abs(even-odd);
			if(odd == even) {
				day = odd+ even;
			}else if(odd > even){
				day += even*2;
				day += 2*subnum -1;
			}else if(even>odd) {
				while(Math.abs(even-odd) > 2) {
					odd += 2;
					even--;
				}
				subnum = Math.abs(even-odd);
				if(subnum == 1) {
					day = 2*odd + 2;
				}else if(subnum == 2) {
					day = 2*odd + 3;
				}else if(subnum == 0) {
					day = 2*odd; 
				}
			}
			sb.append(day + "\n");
		}
		System.out.println(sb);
	}                 
}
