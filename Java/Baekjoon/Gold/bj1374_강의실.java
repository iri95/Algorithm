package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1374_강의실 {
	static int N;

	private static class lecture implements Comparable<lecture> {

		int start, end;

		public lecture(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int compareTo(lecture o) {
			return this.start != o.start ? Integer.compare(this.start, o.start) : Integer.compare(this.end, o.end);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		lecture[] list = new lecture[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			list[i] = new lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(list);

		List<lecture> result = new ArrayList<lecture>();
		result.add(list[0]);

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.offer(list[0].end);
		for (int i = 1; i < N; i++) {
			if (queue.peek() <= list[i].start) {
				queue.poll();
			}
			queue.offer(list[i].end);
		}
		System.out.println(queue.size());

	}

}
