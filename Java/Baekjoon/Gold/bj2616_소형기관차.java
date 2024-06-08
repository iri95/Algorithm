package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2616_소형기관차 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken()) + people[i - 1];
        }
        int K = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][4];
        for (int i = K; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = Math.max(people[i] - people[i - K] + dp[i - K][j - 1], dp[i - 1][j]);
            }
        }
        System.out.println(dp[N][3]);
    }
}
