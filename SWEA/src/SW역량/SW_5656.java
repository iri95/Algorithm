package SW역량;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 벽돌을 쏘는 순서는 중복 순열로 N개
// 순열요소 하나가 끝날떄 마다 block 내리기
// 한번의 순열이 끝나고 블록 다시 초기화
// 만약 깨지는 벽돌이 2이상일 경우 
public class SW_5656 {
	static int N, H, W, minBlock;
	static int[][] block;
	static int[][] blockSample;
	static boolean[][] visit;
	static int[] tgt;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			block = new int[H][W];
			blockSample = new int[H][W];
			visit = new boolean[H][W];
			tgt = new int[N];
			minBlock = Integer.MAX_VALUE;
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					block[i][j] = Integer.parseInt(st.nextToken());
					blockSample[i][j] = block[i][j];
					if(block[i][j] != 0)visit[i][j] = true;
				}
			}
			perm(0);
			sb.append(minBlock + "\n");
		}
		System.out.println(sb);
	}

	static void perm(int tgtIdx) {
		if (tgtIdx == tgt.length) {
			for (int i = 0; i < tgt.length; i++) {
				// 블록에 shot을 실행시킬 좌표를 찾음
				for (int j = 0; j < H; j++) {
					if(blockSample[j][tgt[i]] != 0) {
						shot(j, tgt[i]);
						break;
					}
				}
				
				// 블록 정렬
				for (int x = 0; x < W; x++) {
					for (int y = H-1; y > 0; y--) {
						if(blockSample[y][x] == 0) {
							int k = 0;
							for (int ny = y-1; ny >= 0; ny--) {
								if(blockSample[ny][x]==0)continue;
								k = blockSample[ny][x];
								blockSample[ny][x] = 0;
								visit[ny][x] = false;
								break;
							}
							blockSample[y][x] = k;
							visit[y][x] = true;

						}
					}
				}
			}
			
			int blockCnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(blockSample[i][j] != 0)blockCnt++;
				}
			}
			if(blockCnt<minBlock)minBlock = blockCnt;
			// 블록 초기화
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					blockSample[i][j] = block[i][j];
					if(block[i][j] != 0)visit[i][j] = true;
				}
			}
			return;
		}
		
		for (int i = 0; i < W; i++) {
			tgt[tgtIdx] = i;
			perm(tgtIdx + 1);
		}
	}

	static void shot(int y, int x) {
		int k = blockSample[y][x];
		if(!visit[y][x])return;
		
		blockSample[y][x] = 0;
		visit[y][x] = false;
		if(k == 1) {
			blockSample[y][x] = 0;
			return;
		}
		for (int i = y - k + 1; i < y + k; i++) {
			if(i < 0 || i >= H) continue;
			shot(i,x);
		}
		for (int i = x - k + 1; i < x + k; i++) {
			if(i < 0 || i >= W) continue;
			shot(y,i);			
		}
	}
}
