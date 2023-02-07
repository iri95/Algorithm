package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1244 {
	static int swit, st_many, st_gen, st_number;
	static int[] light;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		swit = Integer.parseInt(br.readLine());
		light = new int[swit];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < swit; i++) {
			light[i] = Integer.parseInt(st.nextToken());
		}
		st_many = Integer.parseInt(br.readLine());
		for (int i = 0; i < st_many; i++) {
			st = new StringTokenizer(br.readLine());
			st_gen = Integer.parseInt(st.nextToken());
			st_number = Integer.parseInt(st.nextToken());
			if (st_gen == 1) { // 남자일 경우
				for (int j = 1; j <= swit; j++) {
					if (st_number * j <= swit) {
						light[st_number * j - 1] = (light[st_number * j - 1] + 1) % 2;
					}
				}
			} else { // 여자일 경우
				int right = st_number;
				int left = st_number - 2;
				int count = 0;
				while (right <= swit - 1 && left >= 0) {
					if (light[right] == light[left]) {
						right += 1;
						left -= 1;
						count += 1;
					} else {
						break;
					}
				}
				light[st_number - 1] = (light[st_number - 1] + 1) % 2;
				for (int k = 1; k <= count; k++) {
					light[st_number - 1 - k] = (light[st_number - 1 - k] + 1) % 2;
					light[st_number - 1 + k] = (light[st_number - 1 + k] + 1) % 2;
				}
			}
		}
		for (int i = 0; i < swit; i++) {
			System.out.print(light[i] + " ");
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}
}