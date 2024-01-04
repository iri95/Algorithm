package SW역량;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Hashset?

public class SW_5658_보물상자비밀번호 {
	static int N, K, turn;
	static Set<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			turn = N / 4;
			String s = br.readLine();
			for (int i = 0; i < turn; i++) {
				for (int j = 0; j < 4; j++) {
					int start = (j * turn + i) % N;
					int end = (j * turn + turn + i) % N;
					if (start > end) {
						set.add(s.substring(start, N) + s.substring(0, end));
					} else {
						set.add(s.substring(start, end));
					}
				}
			}
			int[] list = new int[set.size()];
			int i = 0;
			for (String string : set) {
				list[i] = Integer.parseInt(string,16);
				i++;
			}
			Arrays.sort(list);
			sb.append(list[set.size()-K] + "\n");
			set.clear();
		}
		System.out.println(sb);
	}

}
