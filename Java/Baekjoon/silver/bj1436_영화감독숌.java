package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1436_영화감독숌 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		int i = 666;
		while(cnt < n) {
			i++;
			if(Integer.toString(i).contains("666")) {
				cnt++;
			}
		}
		System.out.println(i);
	}

}
