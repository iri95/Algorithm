package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 35 점 부분점수
public class bj14865_곡선자르기 {
	static int out, in, index; // 포함되지 않은 수 : out, 포함하지 않는 수를 구하기 위한 값 : in
	static boolean[] select;

	// 꼭지점 중에서 y가 음수 -> 양수, 양수 -> 음수인 값들의 x 값 저장
	static int[] result = new int[1000001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		out = 0;
		in = 0;
		index = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x0 = Integer.parseInt(st.nextToken());
		int y0 = Integer.parseInt(st.nextToken());
		int x = x0, y = y0, nx, ny;
		for (int i = 0; i < T-1; i++) {
			st = new StringTokenizer(br.readLine());
			nx = Integer.parseInt(st.nextToken());
			ny = Integer.parseInt(st.nextToken());
			if(y < 0 && ny > 0) {
				result[index++] = x;
			}else if(y > 0 && ny < 0) {
				result[index++] = x;
			}
			x = nx;
			y = ny;
		}
		
		// 리스트에서 y값의 부호가 바뀌는 값들을 resultLIst에 저장
		// 첫번째 꼭지점과 마지막 꼭지점의 경우도 생각해줌.
		if (y0 < 0 && y > 0) {
			result[index++] = x0;
		} else if (y0 > 0 && y < 0) {
			result[index++] = x0;
		}

		// 만약 y > 0으로 시작한다면 처음 x값을 제일 뒤로 보내준다.
		if (y0 > 0) {
			int k = result[0];
			result[index] = result[0];
			for (int i = 0; i < index; i++) {
				result[i] = result[i+1];
			}
		}

		// 두개씩 짝을 지어 작은 값을 앞으로 큰값을 뒤로 보내준다.
		for (int i = 0; i < index; i += 2) {
			if(result[i] > result[i+1]) {
				int temp = result[i];
				result[i] = result[i+1];
				result[i + 1] = temp;
			}
		}
		
		// 포함이 여러번 될경우 중첩됨
		select = new boolean[index];
		
		// 다른 봉우리에 포함되는 봉우리의 수를 구함.
		for (int i = 0; i < index - 1; i += 2) {
			for (int j = 0; j < index - 1; j += 2) {
				if (!select[j] && result[i] < result[j] && result[i+1] > result[j+1]) {
					in++;
					select[j] = true;
				}
			}
		}
		
		// 다른 봉우리에 포함하는 봉우리의 수를 구함.
		for (int i = 0; i < index - 1; i += 2) {
			for (int j = 0; j < index - 1; j += 2) {
				if (result[i] < result[j] && result[i + 1] > result[j + 1]) {
					out++;
					break;
				}
			}
		}

		System.out.println((index / 2 - in) + " " + (index / 2 - out));
	}
}
