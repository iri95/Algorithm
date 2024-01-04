package D3;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1225 {
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			String a = br.readLine();
			int k = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			while (true) {
				for (int i = 1; i <= 5; i++) {
					if (queue.peek() - i <= 0) {
						queue.poll();
						queue.add(0);
						k = 1;
						break;
					} else {
						queue.add(queue.poll() - i);
					}
				}
				if (k == 1)
					break;
			}
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
