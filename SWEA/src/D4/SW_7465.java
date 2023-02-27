package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SW_7465 {
	static int N, M, T;
	static int[] parents;
	static StringBuilder sb = new StringBuilder();
	static HashSet<Integer> count = new HashSet<>(); 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];
			makeSet();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			for (int i = 1; i < N+1; i++) {
				count.add(findSet(parents[i]));
			}
			sb.append(count.size());
			count.clear();
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void makeSet() {
		for (int i = 0; i < N+1; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int x) {
		if (parents[x] == x)
			return x;
		else
			return parents[x] = findSet(parents[x]);
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		parents[py] = px;
	}

}
