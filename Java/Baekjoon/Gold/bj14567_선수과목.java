package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14567_선수과목 {
    static int N, M;
    static int[] dp;
    static boolean[][] order;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        Arrays.fill(dp, 1);
        order = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            order[a][b] = true;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if(order[i][j]) dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
