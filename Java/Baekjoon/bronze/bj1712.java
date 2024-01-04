package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1712 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int sub = C - B;
		int count;
		if (sub == 0) {
			count = -1;
		} else {
			count = A / sub;
			while (A - sub * count >= 0) {
				count++;
				if (sub <= 0) {
					count = -1;
					break;
				}
			}
		}
		System.out.println(count);

	}

}
