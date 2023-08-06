package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj13301_타일장식물 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] list = new long[N+1];
        long[] dp = new long[N+1];
        list[1] = 1;
        dp[1] = 4;
        for (int i = 2; i <= N; i++) {
            list[i] = list[i-1] + list[i-2];
            dp[i] = list[i-1] * 2 + list[i] * 4;
        }
        System.out.println(dp[N]);
    }
}
