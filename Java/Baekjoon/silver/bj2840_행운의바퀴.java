package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2840_행운의바퀴 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		char[] list = new char[num];
		boolean[] select = new boolean[26];
		Arrays.fill(list, '?');
		int k = 1;
		String str = "";
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			char b = st.nextToken().charAt(0);
			
			if (list[(k + a) % num] != '?' || select[b-'A']) {
					if (list[(k + a) % num] != b) {
						str = "!";
					}
			}
			list[(k + a) % num] = b;
			select[b - 'A'] = true;
			k += a;
		}
		if (str != "!") {
			for (int i = 0; i < num; i++) {
				str += Character.toString(list[k-- % num]);
			}
		}
		System.out.println(str);
	}
}
