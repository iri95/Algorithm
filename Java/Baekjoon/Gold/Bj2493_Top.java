package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Bj2493_Top {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> stack = new ArrayDeque<>();
	static Deque<Integer> stackNum = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				stack.add(Integer.parseInt(st.nextToken()));
				stackNum.add(i+1);
				sb.append(0 + " ");
			} else {
				int a = Integer.parseInt(st.nextToken());
				if (stack.peekLast() < a) {
					while (!stack.isEmpty() && stack.peekLast() < a) {
						stack.removeLast();
						stackNum.removeLast();
					}
					if (stack.isEmpty()) {
						sb.append(0 + " ");
					} else {
						sb.append(stackNum.peekLast() + " ");
					}
					stack.add(a);
					stackNum.add(i+1);
				} else {
					sb.append(stackNum.peekLast() + " ");
					stack.add(a);
					stackNum.add(i+1);
				}
			}
		}
		System.out.println(sb);
	}

}
