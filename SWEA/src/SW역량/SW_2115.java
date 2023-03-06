package SW역량;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 테케 49/50
public class SW_2115 {
	static int[][] tgt;
	static int[][] map;
	static int N, M, C, max, maxValue, maxK;
	static StringBuilder sb = new StringBuilder();
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			tgt = new int[2][M];
			select = new boolean[M];
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0, 0);
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}

	static void comb(int nx, int tgtIdx) {
		int y = nx / N;
		int x = nx % N;
		int sum = 0;
		if (tgtIdx == 2) {
			for (int i = 0; i < 2; i++) {
				maxValue = Integer.MIN_VALUE;
				maxK = Integer.MIN_VALUE;
				combSum(tgt[i], 0);
				sum += maxValue;
			}
			max = Math.max(max, sum);
			return;
		}

		// y가 N이 되었을 경우 끝낸다.
		if (y == N)
			return;

		// x가 범위 밖으로 나가는 경우를 다음으로 넘김
		if (N - 1 < M + x - 1) {
			comb(nx + 1, tgtIdx);
		} else {
			// tgt에 map에서 벌꿀의 양을 넣어줌
			for (int i = x, a = 0; i < x + M; i++, a++) {
				tgt[tgtIdx][a] = map[y][i];
			}
			// 벌이 채집할 경우
			comb(nx + M, tgtIdx + 1);
			// 벌이 채집하지 않을 경우
			comb(nx + 1, tgtIdx);
		}
	}

	// 배열에서 부분집합을 구해 C보다 작거나 같은 값들 제곱의 최대값을 찾아내 반환
	static void combSum(int[] a, int srcIdx) {

		if (srcIdx == a.length) {
			int k = 0;
			int pow = 0;
			for (int i = 0; i < a.length; i++) {
				// 부분집합에 포함되는 경우
				if (select[i]) {
					k += a[i];
					pow += a[i] * a[i];
				}
			}
			// 꿀의 양이 C 초과일 경우 취소
			if (k > C)
				return;

			// 제곱값이 더 큰 것을 저장
			maxValue = Math.max(maxValue, pow);
			return;
		}

		select[srcIdx] = true;
		combSum(a, srcIdx + 1);
		select[srcIdx] = false;
		combSum(a, srcIdx + 1);
	}
}
