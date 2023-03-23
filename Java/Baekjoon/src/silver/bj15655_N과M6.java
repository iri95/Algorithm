package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15656_N과M6 {
	static int N, M, k;
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
		k = src[0];
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
			if(select[i] || src[i] < k)continue;
			tgt[tgtIdx] = src[i];
			select[i] = true;
			k = src[i];
			perm(tgtIdx + 1);
			k = src[i];
			select[i] = false;
		}
	}
}
