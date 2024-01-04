package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1577_도로의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        boolean[][][] repair = new boolean[2][M+1][N+1];
        long[][] dp = new long[M + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (x1 - x2 != 0) {
                repair[0][y1][Math.min(x1,x2)] = true;
            } else if (y1 - y2 != 0) {
                repair[1][Math.min(y1,y2)][x1] = true;
            }
        }
        for (int i = 1; i <= N; i++) {
            if(repair[0][0][i-1]){
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i <= M; i++) {
            if(repair[1][i-1][0]){
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (!repair[0][i][j - 1]) {
                    dp[i][j] += dp[i][j - 1];
                }
                if(!repair[1][i-1][j]){
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[M][N]);

    }
}