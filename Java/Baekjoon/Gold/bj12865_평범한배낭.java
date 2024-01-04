package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12865_평범한배낭 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int W = Integer.parseInt(st.nextToken()); 

		int[] weights = new int[N + 1];
		int[] profits = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}

		int[][] D = new int[N + 1][W + 1];

		for (int i = 1; i <= N; i++) { 
			for (int w = 1; w <= W; w++) { 
				if (weights[i] > w) {
					D[i][w] = D[i - 1][w];
				} else {
					D[i][w] = Math.max(D[i - 1][w], profits[i] + D[i - 1][w - weights[i]]);
				}
			}
		}

		System.out.println(D[N][W]);

	}

}
