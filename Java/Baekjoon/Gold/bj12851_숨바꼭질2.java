package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj12851_숨바꼭질2 {
	static int N, K;
	static int[] route = new int[100001];
	static int[] routeCnt = new int[100001];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(route, -1);
		Arrays.fill(routeCnt, 1);
		if (N == K) {
			sb.append(0 + "\n");
			sb.append(1 + "\n");
		} else {
			bfs(N);
			sb.append(route[K] + "\n");
			sb.append(routeCnt[K] + "\n");
		}
		System.out.println(sb);
	}

	static void bfs(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			while (size-- > 0) {
				int p = queue.poll();
				int plus = p + 1;
				int minus = p - 1;
				int multi = p * 2;
				if (route[K] != -1) {
					if (plus != K && minus != K && multi != K) continue;
				}
				if (plus <= 100000) {
					if(route[plus] == -1) {
						queue.offer(plus);
						route[plus] = cnt;
						routeCnt[plus] = routeCnt[p];
					}else {
						if(route[plus] == cnt)routeCnt[plus] += routeCnt[p];
					}
					
				}
				if (minus >= 0) {
					if(route[minus] == -1) {
						queue.offer(minus);
						route[minus] = cnt;
						routeCnt[minus] = routeCnt[p];
					}else {
						if(route[minus] == cnt)routeCnt[minus] += routeCnt[p];

					}
				}
				if (multi <= 100000) {
					if(route[multi] == -1) {
						queue.offer(multi);
						route[multi] = cnt;
						routeCnt[multi] = routeCnt[p];
					}else {
						if(route[multi] == cnt)routeCnt[multi] += routeCnt[p];
					}
				}
			}
			if (route[K] != -1) break;
		}
	}
}