package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj21758_꿀따기 {
	static int N, max;
	static int[] list, left, right;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		left = new int[N];
		right = new int[N];
		max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		left[0] = 0;
		right[0] = 0;
		for (int i = 1; i < N; i++) {
			left[i] = left[i-1] + list[i];
			right[i] = list[N-i-1] + right[i-1];
		}
		// 제일 오른쪽에 있는경우
		// 제일 왼쪽에 하나고정, 나머지 하나는 한칸씩 옮기면서 두개의 합이 가장 큰 값을 저장
		// 중간일 경우 제일 왼쪽, 오른쪽 경우
		// 오른쪽두개, 왼쪽 두개경우
		// 제일 왼쪽의 경우 오른쪽 고정, 나머지 하나는 한칸 씩 옮기면서 두개의 합이 가장 큰 값을 저장
		for (int i = 0; i < N; i++) {
			if(i == N-1) {
				for (int j = 1; j < N-1; j++) {
					max = Math.max(max, left[N-1]*2- left[j] - list[j]);
				}
			}else if(i == 0) {
				for (int j = 1; j < N - 1; j++) {
					max = Math.max(max, right[N-1]*2 - right[j] - list[N - j - 1]);
				}
			}else if(i>0 && i < N-1) {
				max = Math.max(max, right[N - i - 1] + left[i]);
			}
		}
		System.out.println(max);
		
	}
	
}
