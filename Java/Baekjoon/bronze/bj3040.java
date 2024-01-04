package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj3040 {
	
	static int N;
	static int[] tgt = new int[7];
	static int[] src = new int[9];
	static int[] result = new int[7];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		
		if(tgtIdx == 7) {
			int sum =0;
			for(int i = 0; i < 7; i++) {
				sum += tgt[i];
			}
			if(sum == 100) {
				for(int a : tgt) {
					System.out.println(a);
				}
				return;
			}
			return;
		}
		if(srcIdx == 9) return;	
		
		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
		
	}
}
