package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/source/77431815
public class bj2157_여행 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[s][e] = Math.max(map[s][e], c);
        }
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[1][1] = 0;
        for (int start = 1; start < N; start++) {
            for (int end = start + 1; end <= N; end++) {
                if (map[start][end] == 0) continue;

                for (int depth = 1; depth < M; depth++) {
                    if (dp[start][depth] == -1) continue;
                    dp[end][depth + 1] = Math.max(dp[end][depth + 1], dp[start][depth] + map[start][end]);
                }
            }
        }
        int ans = 0;
        for (int i = 2; i <= M; i++) {
            ans = Math.max(ans, dp[N][i]);
        }
        System.out.println(ans);
    }
}
