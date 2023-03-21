package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15654_N과M5 {
	static int N, M;
	static int[] tgt;
	static int[] src;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tgt = new int[M];
		src = new int[N];
		select = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(src);
		perm(0);
		System.out.println(sb);
	}

	static void perm(int tgtIdx) {
		if (tgtIdx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tgt[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(select[i])continue;
			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}
}
