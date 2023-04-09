package silver;

import java.util.Scanner;

public class bj11726_2Xn타일링 {
	public static void main(String[] args) {
		int T = 10007;
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		int[] p = new int[N + 2];
		p[1] = 1;
		p[2] = 2;
		for (int i = 3; i < N + 1; i++) {
			p[i] = ((p[i - 1] % T) + (p[i - 2] % T)) % T;
		}
		System.out.println(p[N]);
	}
}
