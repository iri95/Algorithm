package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 초과로 java8로 제출
public class bj10158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		int x = w - Math.abs(w - (p + t) % (w * 2));
		int y = h - Math.abs(h - (q + t) % (h * 2));
		System.out.println(x + " " + y);
	}
}
