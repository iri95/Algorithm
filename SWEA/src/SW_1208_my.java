

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class SW_1208_my {
	static StringBuilder sb = new StringBuilder();
	static int dump_count;
	static int[] boxes = new int[100];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dump_count = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		for (int i = 0; i < 100; i++) {
			boxes[i] = Integer.parseInt(arr[i]);
		}
		flat(dump_count);
		
	}

	public static void flat(int count) {
		int max = 0;
		int min = 100;
		for (int i = 0; i < 100; i++) {
			if (max < boxes[i]) {
				max = boxes[i];
			}
			if (min > boxes[i]) {
				min = boxes[i];
			}
		}
		for (int i = 0; i < 100; i++) {
			if (boxes[i] == max) {
				boxes[i] -= 1;
				break;
			}
		}
		for (int i = 0; i < 100; i++) {
			if (boxes[i] == min) {
				boxes[i] += 1;
				break;
			}
		}
		if (count == 0) {
			System.out.println(max-min);
			return;
		}
		flat(dump_count - 1);
	}

}
