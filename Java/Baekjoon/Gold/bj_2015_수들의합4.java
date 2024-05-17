package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj_2015_수들의합4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int sum = 0;
		long result = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum += Integer.parseInt(st.nextToken());
			result += map.getOrDefault(sum - K, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(result);
    }
}
