package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10835_카드게임 {
    static int N;
    static int[] left, right;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        left = new int[N];
        right = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) left[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) right[i] = Integer.parseInt(st.nextToken());

        dp = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);

        System.out.println(sol(0, 0));
    }

    private static int sol(int l, int r){
        if (l == N || r == N) return 0;

        if (dp[l][r] != -1) return dp[l][r];

        dp[l][r] = Math.max(sol(l + 1, r + 1), sol(l + 1, r));

        if (left[l] > right[r])
            dp[l][r] = Math.max(dp[l][r], sol(l, r + 1) + right[r]);

        return dp[l][r];
    }
}
