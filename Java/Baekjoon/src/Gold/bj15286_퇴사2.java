package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15286_퇴사2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int max = 0;
        int dpMax = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            dpMax = Math.max(dpMax, dp[i - 1]);
            if (i + T - 1 > N) continue;
            dp[i + T - 1] = Math.max(dp[i + T - 1], dpMax + P);
            max = Math.max(max, dp[i + T - 1]);
        }
        System.out.println(max);
    }
}