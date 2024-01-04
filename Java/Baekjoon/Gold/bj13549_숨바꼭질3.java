package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13549_숨바꼭질3 {

	static int N, K;
	static int[] visit = new int[100005]; // 방문 체크 && 초기값 0 이 수 다음 값, 이전 값
	static Queue<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(visit, -1);
		System.out.println(bfs(N, K));
	}

	static int bfs(int N, int K) {
		int minus = 0;
		int plus = 0;
		int multiply = 0;

		visit[N] = 0;
		queue.add(N);
		while (!queue.isEmpty()) {
			int curr = queue.poll();

			if (curr == K)
				break; // queue 에 들어가면서 visit 계산이 되어있다.

			minus = curr - 1;
			plus = curr + 1;
			multiply = curr * 2;
			if (multiply <= 100000 && visit[multiply] == -1) {
				visit[multiply] = visit[curr]; // multiply 까지 오는 동안 걸린 횟수 = 바로 이전 curr 까지 오는 횟수
				queue.offer(multiply);
			}
			if (minus >= 0 && visit[minus] == -1) {
				visit[minus] = visit[curr] + 1; // minus 까지 오는 동안 걸린 횟수 = 바로 이전 curr 까지 오는 횟수 + 1
				queue.offer(minus);
			}

			if (plus <= 100000 && visit[plus] == -1) {
				visit[plus] = visit[curr] + 1; // plus 까지 오는 동안 걸린 횟수 = 바로 이전 curr 까지 오는 횟수 + 1
				queue.offer(plus);
			}

		}
		return visit[K];
	}
}
