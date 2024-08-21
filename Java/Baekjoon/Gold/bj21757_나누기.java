package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj21757_나누기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N + 1];
        for (int i = 1; i <= N; i++) arr[i] += arr[i - 1] + Long.parseLong(st.nextToken());
        if (arr[N] % 4 != 0) {
            System.out.println(0);
            return;
        }
        long div = arr[N] / 4;
        long[][] dp = new long[4][N + 1]; // j까지 배열을 (i + 1)개로 나눌 수 있는 개수
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < 4; i++) {
            for (int j = i; j <= N; j++) {
                dp[i][j] = dp[i][j - 1];
                if (arr[j] == div * i) dp[i][j] += dp[i - 1][j - 1];
            }
        }
        System.out.println(dp[3][N - 1]);
    }
}