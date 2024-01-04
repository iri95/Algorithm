package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10250 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = N/H+1;
			int y = N%H;
			if(y == 0) {
				x -= 1;
				y = H;
			}
			if(x<10) {
				sb.append(y).append("0").append(x).append("\n");
			}else {
				sb.append(y).append(x).append("\n");
			}
		}
		System.out.println(sb);
		
		

	}

}
