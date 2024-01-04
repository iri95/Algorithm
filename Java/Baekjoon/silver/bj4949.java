package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj4949 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();
		while (true) {
			stack.clear();
			String sentence = br.readLine();
			if (sentence.charAt(0) == '.')
				break;
			for (int i = 0; i < sentence.length(); i++) {
				if (sentence.charAt(i) == '(') {
					stack.push('(');
				} else if (sentence.charAt(i) == '[') {
					stack.push('[');
				} else if (sentence.charAt(i) == ')') {
					if (!stack.isEmpty()) {
						if (stack.pop() != '(') {
							sb.append("no" + "\n");
							break;
						}
					} else {
						sb.append("no" + "\n");
						break;
					}
				} else if (sentence.charAt(i) == ']') {
					if (!stack.isEmpty()) {
						if (stack.pop() != '[') {
							sb.append("no" + "\n");
							break;
						}
					} else {
						sb.append("no" + "\n");
						break;
					}
				} else if (sentence.charAt(i) == '.') {
					if (stack.isEmpty()) {
						sb.append("yes" + "\n");
					} else {
						sb.append("no" + "\n");
					}
				}

			}
		}
		System.out.println(sb);
	}

}
