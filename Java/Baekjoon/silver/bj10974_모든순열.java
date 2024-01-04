package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj10974_모든순열 {
	static boolean[] selected;
	static int[] tgt;
	static int n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tgt = new int[n];
		selected = new boolean[n+1];
		perm(0);
		System.out.println(sb);
		
	}
	static void perm(int tgtIdx) {
		if(tgtIdx == n) {
			for (int i = 0; i < tgt.length; i++) {
				sb.append(tgt[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(selected[i])continue;
			tgt[tgtIdx] = i;
			selected[i] = true;
			perm(tgtIdx + 1);
			selected[i] = false;
		}
	}

}
