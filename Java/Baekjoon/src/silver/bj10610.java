package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10610 {
	static String N, result;
	static int[] nlist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		nlist = new int[N.length()];
		result = "";
		for (int i = 0; i < N.length(); i++) {
			nlist[i] = Character.getNumericValue(N.charAt(i));
		}
		Arrays.sort(nlist);
		if (nlist[0] != 0 || Arrays.stream(nlist).sum()%3 != 0) {
			System.out.println("-1");
		} else {
			for(int i = 0; i < N.length(); i++) {
				result += nlist[N.length()-1-i];
			}
			System.out.println(result);
		}
	}

}
