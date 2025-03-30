package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2281_데스노트 {
    static int n, m, INF = 1_000_000_001;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        dp = new int[n];
        Arrays.fill(dp, INF);
        dp[n - 1] = 0;

        System.out.println(sol(0));
    }

    // 제곱의 합을 반환하는 함수
    private static int sol(int index) {
        if (dp[index] != INF) return dp[index];

        int remain = m - arr[index];
        for (int i = index + 1; i <= n && remain >= 0; i++) {
            if (i == n) {
                dp[index] = 0;
                break;
            }

            dp[index] = Math.min(dp[index], remain * remain + sol(i));
            remain -= arr[i] + 1;
        }
        return dp[index];
    }
}
