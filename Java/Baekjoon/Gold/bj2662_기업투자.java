package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2662_기업투자 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int j = 1; j <= M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= N; i++) dp[0][i] = -1;
        for (int i = 1; i <= M; i++) {
            int[] temp = new int[N + 1];
            for (int j = N; j > 0; j--) {
                int k = map[j][i];
                for (int l = N; l >= j; l--) {
                    if (dp[0][l - j] == -1) continue;
                    if (dp[0][l] < dp[0][l - j] + k && temp[l] < dp[0][l - j] + k) {
                        temp[l] = dp[0][l - j] + k;
                        for (int m = 1; m < i; m++) dp[m][l] = dp[m][l - j];
                        dp[i][l] = j;
                    }
                }
            }
            for (int j = 0; j <= N; j++) if (temp[j] != 0) dp[0][j] = temp[j];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[0][N]).append("\n");
        for (int i = 1; i <= M; i++) sb.append(dp[i][N]).append(" ");
        System.out.println(sb);
    }
}
