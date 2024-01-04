package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1068_트리 {
	static int N, root, cnt;
	static List<Integer>[] list;
	static Queue<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(st.nextToken());
			if (k == -1) {
				root = i;
				continue;
			}
			if (i == d)
				continue;
			list[k].add(i);
		}
		queue.offer(root);
		if (d == root) {
			System.out.println(0);
		} else {
			while (!queue.isEmpty()) {
				int p = queue.poll();
				if (list[p].size() == 0) {
					cnt++;
				} else {
					for (int i = 0; i < list[p].size(); i++) {
						queue.offer(list[p].get(i));
					}
				}

			}
			System.out.println(cnt);
		}

	}

}
