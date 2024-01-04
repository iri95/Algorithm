package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1922_네트워크연결 {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static Edge[] edgeList;
	static int[] parents;

	static void makeSet() {
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine()) + 1;
		E = Integer.parseInt(br.readLine());

		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(edgeList);

		makeSet();
		int result = 0, count = 0;

		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				if (++count == V - 1)
					break;
			}
		}

		System.out.println(result);
	}

}