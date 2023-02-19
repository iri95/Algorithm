package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj9012 {
	static Deque<Character> stack = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			stack.clear();
			String result = "YES";
			String a = br.readLine();
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						result = "NO";
						break;
					}
				}else {
					stack.push(a.charAt(i));
				}
			}
			if(!stack.isEmpty()) {
				result="NO";
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);

	}

}
