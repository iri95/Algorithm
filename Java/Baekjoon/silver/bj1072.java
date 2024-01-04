package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1072 {
	static long X, Y, Z, start, end, mid, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = (Y * 100) / X;
		start = 0;
		end = 1000000000;
		if(Z >= 99) {
			System.out.println(-1);
			return;
		}
		while(start <= end) {
			mid = (start + end) / 2;
			if(((Y+mid) * 100) / (X + mid) != Z) {
				ans = mid;
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		System.out.println(ans);

	}

}
