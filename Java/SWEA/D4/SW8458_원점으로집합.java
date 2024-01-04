package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW8458_원점으로집합 {
	static int T, N, max;
	static int[] point;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			point = new int[N];
			
			// 맨 앞 점부터
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			point[0] = Math.abs(x) + Math.abs(y);
			
			max = point[0];
			// 두번째 점 이후
			// 입력을 읽으면서 max 계산, 모두 홀수 또는 짝수 여부 확인
			boolean stop = false;
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				point[i] = Math.abs(x) + Math.abs(y);
				
				max = Math.max(max, point[i]);
				
				if( point[i] % 2 != point[i-1] % 2) stop = true;
			}
			
			if(stop) {
				System.out.println("#" + t + " -1");
				continue;
			}
			
			//모두 홀수이거나 모두 짝수 조건 충족
			int sum = 0; // 움직이는 거리의 합
			int cnt = 0; // 움직이는 횟수
			
			while(true) {
				if(sum == max || (sum > max && ( sum - max )% 2 == 0))break;
				sum += ++cnt;
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	
	}

}
