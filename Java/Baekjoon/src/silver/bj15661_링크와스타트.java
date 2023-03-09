package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15661_링크와스타트 {
	static boolean[] select;
	static int[][] map;
	static int[] tgt;
	static int N, min;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		select = new boolean[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		subset(0);
		System.out.println(min);
	}
	static void subset(int tgtIdx) {
		if(tgtIdx == N) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if(select[i])cnt++;
			}
			if(cnt == 0 || cnt == N)return;
			int sum1 = 0;
			for (int i = 0; i < N; i++) {
				if(!select[i])continue;
				for (int j = 0; j < N; j++) {
					if(i==j || !select[j])continue;
					sum1 += map[i][j];
				}
			}
			int sum2 = 0;
			for (int i = 0; i < N; i++) {
				if(select[i])continue;
				for (int j = 0; j < N; j++) {
					if(i==j || select[j])continue;
					sum2 += map[i][j];
				}
			}
			min = Math.min(min, Math.abs(sum1-sum2));
			return;
		}
		
		select[tgtIdx] = true;
		subset(tgtIdx + 1);
		select[tgtIdx] = false;
		subset(tgtIdx + 1);
	}

}
