package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2615_오목 {
	static int[][] map = new int[20][20];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int resultX = 0;
		int resultY = 0;
		boolean white = false;
		boolean black = false;
		boolean[][] addadd = new boolean[20][20];
		boolean[][] zeroadd = new boolean[20][20];
		boolean[][] add0 = new boolean[20][20];
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if(map[i][j] == 1) {
					int y = i;
					int x = j;
					int cnt1 = 0;
					while(y<20 && x < 20 && map[y][x] == 1 && !addadd[y][x]) {
						addadd[y][x]=true;
						cnt1++;
						y++;
						x++;
					}
					int cnt2 = 0;
					y = i;
					x = j;
					while(x < 20 && map[y][x] == 1 && !zeroadd[y][x]) {
						zeroadd[y][x] = true;
						cnt2++;
						x++;
					}
					int cnt3 = 0;
					y = i;
					x = j;
					while(y > 0 && x < 20 && map[y][x] == 1) {
						cnt3++;
						y--;
						x++;
					}
					int cnt4 = 0;
					y = i;
					x = j;
					while(y < 20 && map[y][x] == 1 && !add0[y][x]) {
						add0[y][x]= true;
						cnt4++;
						y++;
					}
					
					if(cnt1 == 5 || cnt2 == 5 || cnt3 == 5 || cnt4 == 5) {
						white=true;
						resultX = j;
						resultY = i;
						break;
					}
				}
			}
			if(white)break;
		}
		addadd = new boolean[20][20];
		zeroadd = new boolean[20][20];
		add0 = new boolean[20][20];
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if(map[i][j] == 2) {
					int y = i;
					int x = j;
					int cnt1 = 0;
					while(y<20 && x < 20 && map[y][x] == 2 && !addadd[y][x]) {
						addadd[y][x]=true;
						cnt1++;
						y++;
						x++;
					}
					int cnt2 = 0;
					y = i;
					x = j;
					while(x < 20 && map[y][x] == 2 && !zeroadd[y][x]) {
						zeroadd[y][x] = true;
						cnt2++;
						x++;
					}
					int cnt3 = 0;
					y = i;
					x = j;
					while(y > 0 && x < 20 && map[y][x] == 2) {
						cnt3++;
						y--;
						x++;
					}
					int cnt4 = 0;
					y = i;
					x = j;
					while(y < 20 && map[y][x] == 2 && !add0[y][x]) {
						add0[y][x] = true;
						cnt4++;
						y++;
					}
					
					if(cnt1 == 5 || cnt2 == 5 || cnt3 == 5 || cnt4 == 5) {
						black=true;
						resultX = j;
						resultY = i;
						break;
					}
				}
			}
			if(black)break;
		}
		
		if(white && black) {
			System.out.println(0);
		}else if(white) {
			System.out.println(1 + "\n" + resultY + " " + resultX);
		}else if(black) {
			System.out.println(2 + "\n" + resultY + " " + resultX);
		}else {
			System.out.println(0);
		}
		
	}

}
