package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj10773 {

	public static void main(String[] args) throws Exception {
		Deque<Integer> stack = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a != 0) {
				stack.push(a);
			}else {
				stack.pop();
			}
		}
		int sum = 0;
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			sum += stack.pop();
		}
		System.out.println(sum);

	}

}
