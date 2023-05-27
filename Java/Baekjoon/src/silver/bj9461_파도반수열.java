package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9461_파도반수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] list = new long[101];
		list[1] = 1;
		list[2] = 1;
		list[3] = 1;
		list[4] = 2;
		list[5] = 2;
		list[6] = 3;
		list[7] = 4;
		list[8] = 5;
		list[9] = 7;
		list[10] = 9;
		for (int i = 11; i < 101; i++) {
			list[i] = list[i-1] + list[i-5];
		}
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(list[N]);
		}

	}

}
