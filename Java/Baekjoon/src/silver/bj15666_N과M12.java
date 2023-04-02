package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj15666_N과M12 {
	static int N, M;
	static int[] src;
	static int[] tgt;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		src = new int[N];
		tgt = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(src);
		perm(0);
		System.out.println(sb);

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
			if(tgtIdx != 0) {
				if( src[i] >= tgt[tgtIdx-1]) {
					tgt[tgtIdx] = src[i];
				}else continue;
			}else {
				tgt[tgtIdx] = src[i];
			}
			perm(tgtIdx + 1);
		}
	}
}
