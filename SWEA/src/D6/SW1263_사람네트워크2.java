package D6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1263_사람네트워크2 {
	static final int INF = 9999999;
	static int N, adjMatrix[][], min;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			adjMatrix = new int[N][N];
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					adjMatrix[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && adjMatrix[i][j] == 0) {// 자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
						adjMatrix[i][j] = INF;
					}
				}
			}
			print();
			// 출발지-->경유지-->목적지로 3중 루프 돌리면 오답
			// 경유지-->출발지-->목적지로 3중 루프 돌려야 정답
			for (int k = 0; k < N; ++k) {
				for (int i = 0; i < N; ++i) {
					if (i == k)
						continue; // 출발지와 경유지가 같다면 다음 출발지
					for (int j = 0; j < N; ++j) {
						if (i == j || k == j)
							continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						}
					}
				}
				print();
			}
			sb.append("#" + t + " " + min+"\n");
		}
		System.out.println(sb);
	}

	private static void print() {
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; ++i) {
			int sum = 0;
			for (int j = 0; j < N; ++j) {
				sum += adjMatrix[i][j];
			}
			min = Math.min(sum, min);
		}
	}
}
