package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1654_랜선자르기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] list = new int[K];
		for (int i = 0; i < K; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(list);
		long start = 1;
		long end = list[K-1];
		long mid = (start + end) / 2;

		while(start <= end) {
			long numSum = 0;
			mid = (start + end) / 2;
			for(int i = 0; i< K; i++) {
				numSum += (list[i]/mid);
			}
			if(numSum < N) {
				end = mid - 1;
			}else if(numSum >= N){
				start = mid + 1;
			}
		}
		System.out.println(end);
	}

}
