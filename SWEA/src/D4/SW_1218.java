package D4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SW_1218 {
	static Deque<Character> stack = new ArrayDeque<>();
	static int N;
	static String a;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			N = Integer.parseInt(br.readLine());
			a = br.readLine();
			int result = 1;
			for (int i = 0; i < N; i++) {
				if (a.charAt(i) == ')') {
					if (stack.pop() != '(') {
						result= 0;
						break;
					}
				} else if (a.charAt(i) == '}') {
					if (stack.pop() != '{') {
						result= 0;
						break;
					}
				} else if (a.charAt(i) == ']') {
					if (stack.pop() != '[') {
						result= 0;
						break;
					}
				} else if (a.charAt(i) == '>') {
					if (stack.pop() != '<') {
						result= 0;
						break;
					}
				} else {
					stack.push(a.charAt(i));
				}
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);

	}
}