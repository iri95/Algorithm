package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13398_연속합2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        int[][] dp = new int[N][2];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int max = list[0];
        dp[0][1] = -1000;
        dp[0][0] = list[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + list[i], list[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + list[i]);
            max = Math.max(Math.max(dp[i][0], dp[i][1]), max);
        }
        System.out.println(max);
    }
}
