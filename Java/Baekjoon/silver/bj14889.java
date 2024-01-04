package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14889 {
	static int[] tgt;
	static int[][] map;
	static int tgtIdx, srcIdx, N, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tgt = new int[N / 2];
		min = Integer.MAX_VALUE;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(min);
	}

	static void comb(int tgtIdx, int srcIdx) {
		int sum1 = 0;
		int sum2 = 0;
		if (tgtIdx == tgt.length) {
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < N/2; j++) {
					sum1 += map[tgt[i]][tgt[j]];
				}
			}
			boolean[] select = new boolean[N];
			for (int i = 0; i < N/2; i++) {
				select[tgt[i]] = true;
			}
			for (int i = 0; i < N; i++) {
				if(select[i])continue;
				for (int j = 0; j < N; j++) {
					if(select[j])continue;
					sum2 += map[i][j];
				}
			}
			
			min = Math.min(min,Math.abs(sum1 - sum2));
			return;
		}
		if (srcIdx == N)
			return;
		tgt[tgtIdx] = srcIdx;
		comb(tgtIdx + 1, srcIdx + 1);
		comb(tgtIdx, srcIdx + 1);
		
	}

}
