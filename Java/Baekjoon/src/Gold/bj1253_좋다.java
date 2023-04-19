package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1253_좋다 {
	static int N, cnt, start, end;
	static int[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		
		for (int i = 0; i < N; i++) {
			start = 0;
			end = N-1;
			while (start < end) {
				
				if(start == i) start++;
				else if(end== i)end--;
				
				if(start >= end ) break;
				
				if (list[i] == list[start] + list[end]) {
					cnt++;
					break;
				}else if (list[i] > list[start] + list[end]) {
					start++;
				} else{
					end--;
				}
			}
		}
		System.out.println(cnt);
	}
}
