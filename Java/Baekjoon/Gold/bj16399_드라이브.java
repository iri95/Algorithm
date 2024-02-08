package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj16399_드라이브 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        long[][] dp = new long[D + 1][C + 1];
        long maxValue = Long.MAX_VALUE;
        for (int i = 1; i <= D; i++) {
            Arrays.fill(dp[i], maxValue);
        }
        for (int i = 1; i <= C / E + 1 && i <= D; i++) {
            for (int j = C - E * i; j >= 0; j--) {
                dp[i][j] = dp[i - 1][j + E];
            }
        }
        int N = Integer.parseInt(br.readLine());
        if (N != 0) {
            int[] list = new int[N];
            int[] listValue = new int[N];
            int listSum = 0;
            st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                listSum += Integer.parseInt(st.nextToken());
                list[i] = listSum;
                listValue[i] = Integer.parseInt(st2.nextToken());
                if (dp[list[i]][0] == maxValue) break;
                for (int j = 1; j <= C; j++) {
                    dp[list[i]][j] = Math.min(dp[list[i]][j], dp[list[i]][j - 1] + listValue[i]);
                }
                int count = 0;
                for (int j = list[i] + 1; j < list[i] + C / E + 1 && j <= D; j++) {
                    count++;
                    for (int k = C - E * count; k >= 0; k--) {
                        dp[j][k] = dp[j - 1][k + E];
                    }
                }
            }
        }
        System.out.println(dp[D][0] == maxValue ? -1 : dp[D][0]);
    }
}
