package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj10845 {
	static ArrayList<Integer> queue = new ArrayList<>();
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
				queue.add(a);
				break;
			case "pop":
				if (queue.size() == 0) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.get(0) + "\n");
					queue.remove(0);
				}
				break;
			case "size":
				sb.append(queue.size() + "\n");
				break;
			case "empty":
				if (queue.size() == 0) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
				break;
			case "front":
				if (queue.size() == 0) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.get(0) + "\n");
				}
				break;
			case "back":
				if (queue.size() == 0) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.get(queue.size() - 1) + "\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
