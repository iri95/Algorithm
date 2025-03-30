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

        System.out.println(sol(1, m - arr[0]));
    }

    // 제곱의 합을 반환하는 함수
    private static int sol(int index, int remain) {
        if (index == n) return 0;

        if (dp[index][remain] != INF) return dp[index][remain];

        // 다음 줄에 쓰는 경우
        int min = sol(index + 1, m - arr[index]) + remain * remain;

        // 이번 줄에 쓰는 경우
        if (remain > arr[index])
            min = Math.min(min, sol(index + 1, remain - arr[index] - 1));

        return dp[index][remain] = min;
    }
}
