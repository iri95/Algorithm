package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj10828 {
	static ArrayList<Integer> stack = new ArrayList<>();
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				int a = Integer.parseInt(st.nextToken());
				stack.add(a);
				break;
			case "pop":
				if (stack.size() == 0) {
					sb.append(-1+"\n");
				} else {
					sb.append(stack.get(stack.size() - 1)+"\n");
					stack.remove(stack.size() - 1);
				}
				break;
			case "size":
				sb.append(stack.size()+"\n");
				break;
			case "empty":
				if (stack.size() == 0) {
					sb.append(1+"\n");
				} else {
					sb.append(0+"\n");
				}
				break;
			case "top":
				if (stack.size() == 0) {
					sb.append(-1+"\n");
				} else {
					sb.append(stack.get(stack.size() - 1)+"\n");
				}
				break;
			}
		}
		System.out.println(sb);

	}

}
