package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1495_기타리스트 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] list = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		boolean[][] visit = new boolean[N+1][M+1];
		visit[0][S] = true;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if(visit[i-1][j]) {
					if(j + list[i-1] <= M)
						visit[i][j+list[i-1]] = true;
					if(j - list[i-1] >= 0)
						visit[i][j-list[i-1]] = true;
				}
			}
		}
		int result = -1;
		for (int i = 0; i <= M; i++) {
			if(visit[N][i])result = i;
		}
		if(result == -1) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}

	}

}
