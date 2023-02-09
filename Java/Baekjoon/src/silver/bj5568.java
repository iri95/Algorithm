package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bj5568 {
	static int n, k;
	static String[] nlist, tgt;
	static boolean[] select;
	static HashSet<String> set = new HashSet<String>();
	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		nlist = new String[n];
		tgt = new String[k];
		select = new boolean[n];

		for (int i = 0; i < n; i++) {
			nlist[i] = br.readLine();
		}

		stringsum(0);
		System.out.println(set.size());
	}

	static void stringsum(int tgtIdx) {
		String a= "";
		if (tgtIdx == k) {
			for (int i = 0; i < k; i++) {
				a = a + tgt[i];
			}
			set.add(a);
			a = "";
			return;
		}

		for (int i = 0; i < n; i++) {
			if (select[i])
				continue;
			tgt[tgtIdx] = nlist[i];
			select[i] = true;
			stringsum(tgtIdx + 1);
			select[i] = false;
		}

	}

}
