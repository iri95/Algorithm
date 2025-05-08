package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj13392_방법을출력하지않는숫자맞추기 {
    static int N, INF = Integer.MAX_VALUE;
    static int[] arr, target;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        target = new int[N];
        dp = new int[N][10];
        String str = br.readLine();
        String tar = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i) - '0';
            target[i] = tar.charAt(i) - '0';
            Arrays.fill(dp[i], INF);
        }

        System.out.println(sol(0, 0));

    }

    private static int sol(int n, int cnt) {
        if (N == n) return 0;
        int num = (arr[n] + cnt) % 10;
        if (dp[n][num] != INF) return dp[n][num];

        // 오른쪽으로 돌린 경우
        int count = (10 + target[n] - num) % 10;
        dp[n][num] = Math.min(dp[n][num], sol(n + 1, (cnt + count) % 10) + count);

        // 왼쪽으로 돌린 경우
        count = (10 + num - target[n]) % 10;
        dp[n][num] = Math.min(dp[n][num], sol(n + 1, cnt) + count);

        return dp[n][num];
    }
}
