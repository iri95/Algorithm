package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11728_배열합치기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] listA = new int[a + b];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			listA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = a; i < a+b; i++) {
			listA[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(listA);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < listA.length; i++) {
			sb.append(listA[i] + " ");
		}
		System.out.println(sb);
	}

}
