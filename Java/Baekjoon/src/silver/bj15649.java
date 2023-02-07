package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 자연수 그대로 1씩 증가하는 수가 src 이므로 src 배열을 따로 두지 않고, select 배열과 그 index를 이용해서 해결
public class bj15649 {

	static int N, M;
	static int[] tgt;
	static boolean[] select;

	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		
		select = new boolean[N+1];
		tgt = new int[M];
		
		perm(0, select, tgt);
		System.out.println(sb);
	}
	static void perm(int tgtIdx, boolean[] select, int[] tgt) {
		if (tgtIdx == M) {
			for (int n : tgt) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (select[i])
				continue;

			tgt[tgtIdx] = i;
			select[i] = true;
			perm(tgtIdx + 1, select, tgt);
			select[i] = false;
		}
	}
}
