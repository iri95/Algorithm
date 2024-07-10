package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1695_팰린드롬만들기 {
    static int N;
    static int[] list;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++)
            list[i] = Integer.parseInt(st.nextToken());
        System.out.println(sol(0, N - 1));
    }

    static int sol(int l, int r) {
        if (l >= r) return 0;
        if (dp[l][r] != 0) return dp[l][r];
        if (list[l] == list[r]) return dp[l][r] = sol(l + 1, r - 1);
        else return dp[l][r] = Math.min(sol(l + 1, r) + 1, sol(l, r - 1) + 1);
    }
}
