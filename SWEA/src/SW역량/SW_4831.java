package SW역량;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4831 {
	static int K, N, M, hp;
	static boolean[] station;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			station = new boolean[N + 1];
			visit = new boolean[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int idx = Integer.parseInt(st.nextToken());
				station[idx] = true;
			}
			hp = K;
			int site = 0;
			int stSite = 0;
			int siteHp = 0;
			int cnt = 0;
			int result = 0;
			while (--hp >= 0) {
				// index를 하나씩 돌다가 충전소 index를 저장 hp가 0 일때 마지막 인덱스를
				// 현재 인덱스로 바꾸고 그때의 hp에 K를 더한다.
				site++;
				if (site == N) {
					result = cnt;
					break;
				}
				if (station[site]) {
					stSite = site;
					siteHp = hp;
				}
				if (hp == 0 && !visit[stSite]) {
					site = stSite;
					visit[site] = true;
					hp = K;
					cnt++;
				}
			}
			if (site != N) {
				sb.append(0+ "\n");
			} else {
				sb.append(result+ "\n");
			}
		}
		System.out.println(sb);
	}

}
