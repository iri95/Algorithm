package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2098_외판원순회_pro {
	static int N, allMask, INF = 987654321;
	static int[][] W;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 자료구조
		allMask = (1 << N) - 1; // 5개 도시 => 11111 => 1 << 5 = 100000 여기서 -1 해주면 11111
		W = new int[N][N];
		dp = new int[N][allMask];
		
		// 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 풀이 
		System.out.println( tsp(0, 1));
	}
	
	// idx 도시부터 아직 방문하지 않은 남은 모든 도시를 방문하는 최소 비용을 return
	static int tsp(int idx, int mask) {
		
		// 기저조건
		// 모든 도시를 방문 => 돌아가는 비용 확인
		if(mask == allMask ) {
			if(W[idx][0] == 0 ) return INF; // 처음으로 되돌아가지 못하는 경우
			else return W[idx][0]; // 처음으로 되돌아가는 비용 리턴
		}
		
		// 이미 이전에 계산된 값이 존대
		if( dp[idx][mask] != 0 ) return dp[idx][mask];
		
		// 최소비용 초기화
		dp[idx][mask] =  INF;
		
		// 남은 도시를 모두 방문하는 최소 비용 계산
		for (int i = 0; i < N; i++) {
			// 갈 수 있거나, 이미 방문했으면 skip
			if( W[idx][i] == 0 || (mask & (1 << i )) != 0) continue;
			
			// 남은 i를 거치는 비용과 현재 비용을 비교하면서 최소값 경신
			dp[idx][mask] = Math.min(dp[idx][mask], tsp(i, mask | ( 1 << i)) + W[idx][i]);
		}
		
		return dp[idx][mask];
	}
}

// N 이 주어진다. 16! => 20조 : 단순 순열 알고리즘 시간 초과
// DP( memoization ) + BitMaking 을 이용해서 풀이
// #1 순회
//    아래 그림처럼 1-2-4-5-3 이나 다른 점 가령 4-5-3-1-2 이 모두 같다
//    1 ---- 2
//    /     /
//	 /     4
//  /     /
// 3 --- 5
// 1번에서부터 출발하는 최소 비용을 계산하면 다른 번호는 계산하지 않아도 된다.

// #2 BitMasking 으로 현재까지 방문한 도시를 표현
//        - 0001 => 1 번 도시 방문
//        - 1010 => 4, 2 번 도시 방문
//        - 1101 => 4, 3, 1 번 도시 바움

// #3 DP 자료 구조
//    - 2차원 배열
//    - dp[i][j] => 현재 i번 도시에 있고, 거쳐온 도시들이 j( BM ), 남은 도시를 모두 방문하는 최소 비용의 값을 저장
//    - 1, 2, 3, 4, 5, 6, 7 도시가 있을 때 dp[3][1100101] => 현재 3번 도시를 방문, 거쳐온 도시는 1, 3, 6, 7번 도시이다.
//      3번에서 남은 2, 4, 5 도시를 방문하는 최소 비용을 dp[3][1100101] 저장
//      dp[3][1100101] = a 라고 한 번 계산해 놓으면 앞선 1, 6, 7 도시를 어떤 순서로 방문하더라도 그 이후의 비용을 동일하다.