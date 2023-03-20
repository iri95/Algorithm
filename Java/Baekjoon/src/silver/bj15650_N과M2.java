package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15650_N과M2 {
	static int N, M;
	static int[] tgt;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tgt = new int[M];
		select = new boolean[N + 1];
		perm(0, 1);
		System.out.println(sb);
	}

	static void perm(int tgtIdx, int srcIdx) {
		if (tgtIdx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tgt[i] + " ");
			}
			sb.append("\n");
			return;
		}

		if (srcIdx == N+1)return;
		tgt[tgtIdx] = srcIdx;
		perm(tgtIdx + 1, srcIdx + 1);
		perm(tgtIdx, srcIdx + 1);
	}
}
