package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14501_퇴사 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            if(i + T -1 > N)continue;
            int dpMax = 0;
            for (int j = 0; j <i; j++) {
                dpMax = Math.max(dpMax, dp[j]);
            }
            dp[i + T - 1] = Math.max(dp[i + T - 1], dpMax + P);
        }
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
