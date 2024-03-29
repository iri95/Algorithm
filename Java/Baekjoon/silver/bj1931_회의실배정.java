package silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bj1931_회의실배정 {

	private static class Meeting implements Comparable<Meeting> {

		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? Integer.compare(this.end, o.end) : Integer.compare(this.start, o.start);
			// 종료 시간이 같을 경우 시작시간을 비교
			// 다른 경우
			// 상대가 크면 음수가되어 그대로,
			// 값이 양수일 경우 교환 => 종료시간이 빠른 순(오름차순)
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Meeting[] m = new Meeting[count];
		for (int i = 0; i < count; i++) {
			m[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(m);

		List<Meeting> result = new ArrayList<Meeting>();
		result.add(m[0]);
		for (int i = 1; i < count; i++) {
			// 마지막 회의의 종료시간보다 현재 회의의 시작시간이 같거나 크다면 양립가능
			if (result.get(result.size() - 1).end <= m[i].start) {
				result.add(m[i]);
			}
		}
		System.out.println(result.size());
	}

}
