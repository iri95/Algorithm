package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2253_점프 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] non = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(br.readLine());
            non[a] = true;
        }
        int MaxJump = (int) Math.sqrt(2 * N) + 1;
        int[][] dp = new int[N + 1][MaxJump + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], 10_001);
        }
        if (non[2]) {
            System.out.println(-1);
            return;
        }
        dp[1][0] = 0;
        dp[2][1] = 1;
        for (int i = 3; i <= N; i++) { // 점프할 칸
            if (non[i]) continue;
            for (int j = 1; j <= (int) Math.sqrt(2 * i); j++) { // 점프할 칸 수
                if (i - j < 0) continue;
                dp[i][j] = Math.min(dp[i - j][j], Math.min(dp[i - j][j - 1], dp[i - j][j + 1])) + 1;
            }
        }
        int ans = 10_001;
        for (int i = 0; i <= MaxJump; i++) {
            ans = Math.min(ans, dp[N][i]);
        }
        if (ans == 10_001) System.out.println(-1);
        else System.out.println(ans);
    }
}

