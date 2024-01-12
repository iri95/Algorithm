package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        int[][] dp = new int[2][N];
        Arrays.fill(dp[0], 1);
        Arrays.fill(dp[1], 1);
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (list[i] < list[j]) {
                    dp[0][j] = Math.max(dp[0][j], dp[0][i] + 1);
                } else if (list[i] > list[j]) {
                    dp[1][j] = Math.max(dp[1][j], Math.max(dp[0][i] + 1, dp[1][i] + 1));
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }
}
