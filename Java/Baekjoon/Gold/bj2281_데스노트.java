package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2281_데스노트 {
    static int n, m, INF = 1_000_000_001;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n][m + 1];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i], INF);
        }

        System.out.println(sol(0, m));
    }

    // 제곱의 합을 반환하는 함수
    private static int sol(int index, int remain) {
        if (dp[index][remain] != INF) return dp[index][remain];

        int pow = (int) Math.pow(remain + 1, 2);

        if (index == n - 1) {
            if (remain >= arr[index]) return 0;
            else return dp[index][remain] = pow;
        }

        if (arr[index] > remain)
            return dp[index][remain] = sol(index, m) + pow;
        else if (arr[index] == remain)
            return dp[index][remain] = Math.min(sol(index + 1, m), sol(index, m) + pow);
        else {
            if (remain != m) {
                return dp[index][remain] = Math.min(sol(index, m) + pow
                        , sol(index + 1, remain - arr[index] - 1));
            } else
                return dp[index][remain] = sol(index + 1, remain - arr[index] - 1);
        }
    }
}
