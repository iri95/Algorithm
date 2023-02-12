package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1735 {
	static int x1, y1, x2, y2, xans, yans;
	static boolean[] select;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		// 유클리드 호제법 공부하기(GCD)
		xans = x1 * y2 + x2 * y1;
		yans = y1 * y2;
		for (int i = 2; i < 30000; i++) {
			list.add(i);
		}
		select = new boolean[list.size()];
		for (int j = 1; j < list.size(); j++) {
			for (int i = j + 1; i < list.size(); i++) {
				if(select[j]) continue;
				if (list.get(i) % list.get(j) == 0) {
					select[i] = true;
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (select[i])
				continue;
			while (xans % list.get(i) == 0 && yans % list.get(i) == 0) {
				xans /= list.get(i);
				yans /= list.get(i);
			}
		}
		System.out.println(xans + " " + yans);
	}
}
