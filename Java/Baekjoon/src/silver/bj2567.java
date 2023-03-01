package silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2567 {
	// map : 흰천, 100*100의 크기지만 dfs에서 false인 부분을 통해 true 값과 만났을 경우 1을 더하므로 
	// 흰천영역인 100* 100 영역 바깥에도 false를 할당해야하므로 102*102로 만듬
	static boolean[][] map = new boolean[102][102];	
	// visit 또한 map과 같은 크기로 만들어줌
	static boolean[][] visit = new boolean[102][102]; // 방문 여부
	// false를 타고 갈 델타
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	// 둘레의 길이를 나타내는 count, false에서 true를 만났을 경우 count에 1씩 더해 준다.
	static int count = 0;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// T는 검은 천의 갯수
		for (int t = 0; t < T; t++) {	// 검은 천의 갯수만큼 반복문
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());	// 검은천의 왼쪽 아래 x좌표를 a에 할당
			int b = Integer.parseInt(st.nextToken());	// 검은천의 왼족 아래 y좌표를 b에 할당
			for (int i = 1; i <= 10; i++) {	// 
				for (int j = 1; j <= 10; j++) {
					// index가 1,1부터 시작한다.
					// 0,0부터 시작할 경우 흰천의 아래에 붙은 둘레길이는 구하지 못하기 떄문.
					map[a+i][b+j] = true;	
				}
			}
		}
		// 이중 for문으로 map에서 false인 부분을 돌아가며 dfs를 돌린다.
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if(map[i][j])continue;
				dfs(i,j);
			}
		}
		// 결과값 출력
		System.out.println(count);
	}
	
	// dfs로 false -> true가 될때마다 count에 +1을 한다.
	static void dfs(int y, int x) {
		// map에서 만약 true(검은 스카프 부분)으로 시작한다면 return;
		// visit로 이미 한번 들린 곳이라면 return;
		if(map[y][x] || visit[y][x])return;
		
		// 방문한 위치 visit의 false를 true로 바꾸어 준다.
		visit[y][x] = true;
		
		// 델타를 돌려준다.
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 범위 밖일경우 continue
			if(nx < 0 || nx >= 102 || ny < 0 || ny >=102)continue;
			// dfs의 시작시 false일 경우만 실행하도록 했기 때문에 map[ny][nx]가 ture일 경우가
			// false와 true가 만나는 지점이므로 count에 1 더해준다.
			if(map[ny][nx]) {
				count++;
			}else {
				// 만약 false -> false일 경우 dfs를 다시 돌려준다.
				dfs(ny,nx);
			}
		}
	}
}
