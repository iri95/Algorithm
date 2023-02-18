package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Bj15686 {
	static int N, M;
	static List<int[]> listN = new ArrayList<>();
	static List<int[]> listM = new ArrayList<>();
	static int[][] tgt;
	static int routeMin = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tgt = new int[M][];
		int value;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				value = Integer.parseInt(st.nextToken());
				int[] temp = new int[2];
				temp[0] = i;
				temp[1] = j;
				if(value == 1) {
					listN.add(temp);
				};
				if(value == 2) {
					listM.add(temp);
				};
			}
		}
		// 함수 실행
		comb(0,0);
		System.out.println(routeMin);
		

	}
	//  M개(src->tgt, 2)의 요소를 가지는 조합을 이용해 각각의 집들과 거리중 최단거리를 구해 출력
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			// 집에서 치킨집 까지의 최소거리들을 더하고 그 값들중 가장 작은 값을 저장
			int min;
			int nm;
			int minSum = 0;
			for(int i = 0; i < listN.size(); i++) {
				min = Integer.MAX_VALUE;
				for (int j = 0; j < tgt.length; j++) {
					nm = Math.abs(listN.get(i)[0] - tgt[j][0]) + Math.abs(listN.get(i)[1] - tgt[j][1]);
					if(min>nm)min = nm;
				}
				// 최소값들을 더해줌
				minSum += min;
			}
			if(routeMin > minSum)routeMin = minSum;
			return;
		}
		
		if(srcIdx == listM.size()) {
			return;
		}
		tgt[tgtIdx] = listM.get(srcIdx);
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}
