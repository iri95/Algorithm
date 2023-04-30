package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj17829_222풀링 {
	
	static int N;
	static int[][] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(divide(N, list)[0][0]);
		
	}
	static int[][] divide(int n, int[][] tList){
		if(n == 1)return tList;
		n /= 2;
		int[][] nList = new int[n][n];
		int k = 0;
		for (int i = 0; i < n*2; i += 2) {
			for (int j = 0; j < n*2; j += 2) {
				int[] temp = new int[4];
				temp[0] = tList[i][j];
				temp[1] = tList[i+1][j];
				temp[2] = tList[i][j+1];
				temp[3] = tList[i+1][j+1];
				Arrays.sort(temp);
				nList[k/n][k%n] = temp[2];
				k++;
			}
		}
		
		return divide(n, nList);
	}
}
