package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj11729 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 2, 3); // 첫 번째 호출의 from to 1 -> 3 탑을 이동
		
		System.out.println(sb);
	}
	
	// 매 단계에서 이동과 관련된 정답은 sb에 append
	static void hanoi(int n, int from, int temp, int to) {
		// 기저 조건
		if(n==0) return;
		// 선행 : to 로 가기전에 n-1개가 temp로 이동
		hanoi(n-1, from, to, temp);
		// 현재 : from의 맨 밑의 원반을 to로 이동 <= 출력 내용
		sb.append(from+" ").append(to+"\n");
		// 후행 : temp에 있는 n-1개를 to로 이동
		hanoi(n-1, temp, from, to);

		
		// 현재 단계에서 수행할 job이 무엇인지 - 1개? 2개? 몇개?
		// 재귀 호출은 언제 할 것인지? 재귀 호출 시 변화를 무엇을 주어야 하는지
		
	}
}
