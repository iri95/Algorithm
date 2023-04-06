package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW5604_구간합 {
	static long[] list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		list = new long[16];
		list[0] = 0;
		for (int i = 1; i < 16; i++) {
			list[i] = (long) (list[i-1]*10 + 45 * (long)Math.pow(10, i-1));
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			sb.append("#" + t + " " + (sum(b) - sum(a-1))+ "\n");
		}
		System.out.println(sb);
	}
	
	static long sum(long a) {
		if(!(a>0))return 0;
		int size = String.valueOf(a).length();
		int[] eachList = new int[size];
		long result = 0;
		for (int i = size-1; i >= 0; i--) {
			eachList[i] = (int) ( a / (long)Math.pow(10, i)); 
			a %= (long)Math.pow(10, i);
			result += (a + 1) * eachList[i]; // 1222 일경우 1000의 1 * 223
		}
		
		
		for (int i = 0; i < size; i++) {
			result += list[i] * eachList[i];
			for (int j = 1; j < eachList[i]; j++) {
				result += j * (long)Math.pow(10, i);
			}
		}
		
		return result;
	}
}
