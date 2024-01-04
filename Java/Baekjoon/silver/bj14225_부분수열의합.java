package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14225_부분수열의합 {
	static int N, sum;
	static int[] list;
	static boolean[] select, visit;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		visit = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		sum = 0;
		for (int i = 0; i < N; i++) {
			list[i] =  Integer.parseInt(st.nextToken());
			sum += list[i];
		}
		select = new boolean[sum + 2];
		Arrays.sort(list);
		subset(0);
		for (int i = 0; i <= sum+1; i++) {
			if(!select[i]) {
				System.out.println(i);
				return;
			}
		}

	}
	static void subset(int idx) {
		if(idx == N) {
			int k = 0;
			for (int i = 0; i < N; i++) {
				if(visit[i]) k += list[i];
			}
			select[k] = true;
			return;
		}
		
		visit[idx] = false;
		subset(idx + 1);
		visit[idx] = true;
		subset(idx + 1);
	}

}
