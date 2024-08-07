package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 324ms -> 228ms : dp 로직을 static 함수로 따로 뺴니까 시간이 줄어듬
public class bj14863_서울에서경산까지 {
    static int N, K;
    static int[][] info;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        info = new int[N + 1][4];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
            info[i][3] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dp());
    }

    static int dp(){
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (dp[i - 1][j] == -1) continue;
                if (j + info[i][0] <= K) {
                    dp[i][j + info[i][0]] = Math.max(dp[i][j + info[i][0]], dp[i - 1][j] + info[i][1]);
                }
                if (j + info[i][2] <= K) {
                    dp[i][j + info[i][2]] = Math.max(dp[i][j + info[i][2]], dp[i - 1][j] + info[i][3]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= K; i++) {
            ans = Math.max(ans, dp[N][i]);
        }
        return ans;
    }
}