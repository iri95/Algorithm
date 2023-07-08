package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2631_줄세우기 {
    static int N;
    static int[] list;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i-1; j > 0; j--) {
                if (list[i] > list[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(N - max);
    }
}
