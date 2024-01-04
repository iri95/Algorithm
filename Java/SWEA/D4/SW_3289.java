package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_3289 {
	static int[] parents;
	static int T, n, m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n + 1];
			makeSet();
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if (op == 0) {
					union(x, y);
				} else if (op == 1) {
					if (findSet(x) == findSet(y)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static void makeSet() {
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}

	// 집합을 표현하는 최상위 부모를 찾아서 return
	static int findSet(int x) {
		if (parents[x] == x)
			return x;
//		else return findSet(parents[x]);
		else
			return parents[x] = findSet(parents[x]);
	}

	// x를 y 집합으로 또는 y를 x 집합으로 이동 X
	// x 가 속한 집합 전체와 y가 속한 집합 전체를 하나로!
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		parents[py] = px; // 앞 파라미터의 집합으로 뒤 파라미터의 집합이 포함
	}
}
