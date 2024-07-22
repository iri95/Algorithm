package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj18427_함께블록쌓기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][H + 1];
        List<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            list[i].add(0);
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) list[i].add(Integer.parseInt(st.nextToken()));
        }
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int h: list[i]) {
                for (int j = 0; j + h <= H; j++) {
                    dp[i][j + h] += dp[i - 1][j];
                    dp[i][j + h] %= 10_007;
                }
            }
        }
        System.out.println(dp[N][H]);
    }
}
