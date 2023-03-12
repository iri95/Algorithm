package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj3986_좋은단어 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < T; i++) {
			Deque<Character> stack = new ArrayDeque<>();
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				if (stack.isEmpty()) {
					stack.push(str.charAt(j));
				} else {
					if (stack.peek() == str.charAt(j)) {
						stack.pop();
					} else {
						stack.push(str.charAt(j));
					}
				}
			}
			if (stack.isEmpty())
				cnt++;
		}
		System.out.println(cnt);
	}

}
