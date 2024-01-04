package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1780_종이의개수 {
	static int N;
	static int[] result = new int[3];
	static int[][] list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		re(0,0,N);
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
	}
	static void re(int y, int x, int n) {
		if(n==1) {
			result[list[y][x]+1]++;
			return;
		}
		
		int k = list[y][x];
		for (int i = y; i < y+n; i++) {
			for (int j = x; j < x+n; j++) {
				if(k != list[i][j]) {
					k = -2;
					break;
				}
			}
			if(k==-2)break;
		}
		
		if(k!= -2) {
			result[k+1]++;
			return;
		}else {
			int a = n/3;
			re(y,x,a);
			re(y+a,x,a);
			re(y+2*a,x,a);
			re(y,x + a,a);
			re(y+a,x + a,a);
			re(y+2*a,x + a,a);
			re(y, x+2*a,a);
			re(y+a, x+2*a,a);
			re(y+2*a, x+2*a,a);
		}
		
	}

}
