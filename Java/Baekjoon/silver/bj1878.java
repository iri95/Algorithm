package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj1878 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> stack = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		int k = 1;
		while (true) {
			int s = Integer.parseInt(br.readLine());
			while (s >= k) {
				stack.push(k);
				k++;
				sb.append("+" + "\n");
			}
			if (stack.pop() != s) {
				sb = new StringBuilder();
				sb.append("NO");
				break;
			} else {
				sb.append("-" + "\n");
			}
			if (k == n + 1 && stack.isEmpty())
				break;

		}
		System.out.println(sb);
	}
}
