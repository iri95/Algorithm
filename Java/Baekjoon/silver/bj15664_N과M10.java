package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj15664_N과M10 {
	static int N, M, k;
	static int[] src;
	static int[] tgt;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		src = new int[N];
		tgt = new int[M];
		select = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(src);
		perm(0);
		System.out.println(sb);
		k = 0;
	}
	
	static void perm(int tgtIdx) {
		if (tgtIdx == M) {
			String a = "";
			for (int i = 0; i < tgtIdx; i++) {
				a += tgt[i] + " ";
			}
			if (set.contains(a))
				return;
			set.add(a);
			sb.append(a).append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (select[i] || k > i)
				continue;
			k = i;
			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			k = i;
			select[i] = false;
		}
	}
}
