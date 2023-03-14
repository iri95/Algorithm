package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20208_진우의민트초코우유 {
	static int N, M, H, result, count;
	static int[] home;
	static int[][] milk;
	static int[][] tgt;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		result = 0;
		int[][] map = new int[N][N];
		home = new int[2];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					home[1] = j;
					home[0] = i;
				}else if(map[i][j] == 2)cnt++;
				
			}
		}
		milk = new int[cnt][2];
		tgt = new int[cnt][2];
		select = new boolean[cnt];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2) {
					milk[cnt][0] = i;
					milk[cnt][1] = j;
					cnt++;
				}
			}
		}
		
		perm(0);
		System.out.println(result);
	}
	static void perm(int tgtIdx) {
		if(tgtIdx == milk.length) {
			int hp = M;
			int x = home[1];
			int y = home[0];
			count = 0;
			for (int i = 0; i < tgt.length; i++) {
				hp -= Math.abs(tgt[i][1]-x) + Math.abs(tgt[i][0] - y);
				if(hp <0)break;
				x = tgt[i][1];
				y = tgt[i][0];
				hp += H;
				count++;
				if(hp >= Math.abs(home[1]-x) + Math.abs(home[0]-y)) {
					if(result < count)result = count;
				}
				
			}
			return;
		}
		
		for (int i = 0; i < milk.length; i++) {
			if(select[i])continue;
			select[i] = true;
			tgt[tgtIdx] = milk[i];
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}

}
