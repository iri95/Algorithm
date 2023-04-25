package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2606_바이러스_adjList1 {
	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return vertex + "link = " + link;
		}
	}

	static int V, E;
	static Node[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		adjList = new Node[V + 1];

		int from, to;
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		boolean[] visit = new boolean[V + 1];
		visit[1] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int k = queue.poll();
			Node temp = adjList[k];
			while (temp != null) {
				if (!visit[temp.vertex]) {
					queue.offer(temp.vertex);
					visit[temp.vertex] = true;
					cnt++;
				}
				temp=temp.link;
			}
		}
		System.out.println(cnt);

	}

}
