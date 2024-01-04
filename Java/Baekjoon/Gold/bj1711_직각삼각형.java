package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// no sol 기하학??
public class bj1711_직각삼각형 {
	static int N, result;
	static long[][] point, tgt;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		point = new long[N][2];
		tgt = new long[3][2];
		StringTokenizer st; 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Long.parseLong(st.nextToken());
			point[i][1] = Long.parseLong(st.nextToken());
			
		}
		comb(0,0);
		System.out.println(result);
	}
	
	static void comb(int tgtIdx, int srcIdx) {
		if(tgtIdx == 3) {
			long l1 = (long) Math.pow(Math.abs(tgt[0][0] - tgt[1][0]),2) + (long) Math.pow(Math.abs(tgt[0][1] - tgt[1][1]),2);
			long l2 = (long) Math.pow(Math.abs(tgt[1][0] - tgt[2][0]),2) + (long) Math.pow(Math.abs(tgt[1][1] - tgt[2][1]),2);
			long l3 = (long) Math.pow(Math.abs(tgt[2][0] - tgt[0][0]),2) + (long) Math.pow(Math.abs(tgt[2][1] - tgt[0][1]),2);
			long[] k = {l1, l2, l3};
			Arrays.sort(k);
			if(k[2] == k[1] + k[0])result++;
			return;
		}
		if(srcIdx >= N) {
			return;
		}
		
		tgt[tgtIdx] = point[srcIdx];
		comb(tgtIdx+ 1, srcIdx+1);
		comb(tgtIdx, srcIdx+1);
	}

}
