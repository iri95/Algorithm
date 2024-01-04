package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2920_음계 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[8];
		for (int i = 0; i < 8; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		String result = "mixed";
		if(a[0] == 8) {
			int s = 8;
			for (int i = 0; i < 8; i++) {
				if(a[i] == s) {
					s--;
				}else break;
			}
			if(s == 0)result="descending";
		}else if(a[0] == 1) {
			int s = 1;
			for (int i = 0; i < 8; i++) {
				if(a[i] == s) {
					s++;
				}else break;
			}
			if(s == 9)result="ascending";
		}
		System.out.println(result);
	}

}
