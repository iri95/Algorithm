package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14728_벼락치기 {
    static int N, T;
    static int[] time, score;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        time = new int[N+1];
        score = new int[N+1];
        int[][] dp = new int[N + 1][T + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= T; j++) {
                if (time[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], score[i] + dp[i - 1][j - time[i]]);
                }
            }
        }
        System.out.println(dp[N][T]);
    }
}
