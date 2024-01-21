package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://loosie.tistory.com/365
public class bj11049_행렬곱셈순서 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N + 1];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[i] = a;
            list[i + 1] = b;
        }

        for (int i = 2; i < N + 1; i++) { // 구간 간격
            for (int j = 0; j < N - i + 1; j++) { // 구간 시작점 j (0~n-i))
                dp[j][j + i - 1] = Integer.MAX_VALUE;
                for (int k = j; k < j + i - 1; k++) { // 중간 지점 k (j~ j+i-1))
                    int value = dp[j][k] + dp[k + 1][j + i - 1] + (list[j] * list[k + 1] * list[j + i]);
                    dp[j][j + i - 1] = Math.min(dp[j][j + i - 1], value);
                }
            }
        }
        System.out.println(dp[0][N - 1]);

    }
}
