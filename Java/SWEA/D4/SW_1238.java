package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1238 {
	static class Node {
		int x;
		Node link;

		public Node(int x, Node link) {
			super();
			this.x = x;
			this.link = link;
		}

	}

	static Node[] list;

	static int last;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			list = new Node[101];
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			last = 0;
			for (int j = 0; j < N / 2; j++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from] = new Node(to, list[from]);
			}
			bfs(M);
			sb.append(last + "\n");
		}
		System.out.println(sb);
	}

	static void bfs(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[101];	// 0~100 까지 방문 여부
		visit[n] = true;
		queue.offer(n);
		while (!queue.isEmpty()) {
			last = 0;
			int size = queue.size();
			while (--size >= 0) {
				int k = queue.poll();
				if(last < k) {
					last = k;
				}
				
				for (Node temp = list[k]; temp != null; temp = temp.link) {
					if (!visit[temp.x]) {
						queue.offer(temp.x);
						visit[temp.x] = true;
					}
				}
			}

		}

	}

}
