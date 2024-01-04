package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1759 {
	static int L, C;
	static char[] str, tgt;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		str = new char[C];
		tgt = new char[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			str[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(str);
		comb(0, 0);
		System.out.println(sb);
	}
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == L) {
			int count = 0;
			for (int i = 0; i < L; i++) {
				if(tgt[i] == 'a' || tgt[i] == 'e' || tgt[i] == 'o' || tgt[i] == 'i' || tgt[i] == 'u') {
					count++;
				}
			}
			if(count == 0 || L-count < 2)return;
			sb.append(String.valueOf(tgt) + "\n");
			return;
		}
		
		if(srcIdx == C)return;
		
		tgt[tgtIdx] = str[srcIdx];
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}
