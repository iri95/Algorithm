package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1072 {
	static long X, Y, Z, Zup, count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = (Y * 100) / X;
		Zup = (Y * 100) / X;
		count = 0;
		while(true) {
			if(Z >= 99) {
				count = -1;
				break;
			}
			X++;
			Y++;
			Zup = (Y * 100) / X;
			count++;
			if(Zup != Z) {
				break;
			}
		}
		System.out.println(count);

	}

}
