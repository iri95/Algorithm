package D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1247 {
	static int n, min, result;
	static boolean[] visit;
	static int[][] map, tgt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result = Integer.MAX_VALUE;
			min = 0;
			n = Integer.parseInt(br.readLine());
			visit = new boolean[n+2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			map = new int[n + 2][2];
			tgt = new int[n][2];
			for (int i = 0; i < n + 2; i++) {
				int[] k = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
				map[i] = k;
			}
			perm(0);
			sb.append("#" + t + " " + result + "\n");
			result = Integer.MAX_VALUE;
		}
		System.out.println(sb);

	}

	static void perm(int tgtIdx) {
		if (tgtIdx == tgt.length) {
			min = 0;
			min += distance(map[0][0], map[0][1], tgt[0][0], tgt[0][1]);
			for (int i = 0; i < tgt.length - 1; i++) {
				min += distance(tgt[i][0], tgt[i][1], tgt[i+1][0], tgt[i+1][1]);
			}
			min += distance(tgt[tgt.length - 1][0], tgt[tgt.length - 1][1], map[1][0], map[1][1]);
			if (result > min)
				result = min;
			return;
		}

		for (int i = 2; i < n + 2; i++) {
			if(visit[i])continue;
			
			visit[i] = true;
			tgt[tgtIdx] = map[i];
			perm(tgtIdx + 1);
			visit[i] = false;
		}
	}

	static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
