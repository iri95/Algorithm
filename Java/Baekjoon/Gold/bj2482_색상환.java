package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2482_색상환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int divide = 1_000_000_003;
        if (K > N / 2) {
            System.out.println(0);
            return;
        }
        // 첫번째를 선택했을 때와 선택하지 않았을 떄
        int[][] dp1 = new int[K + 1][N]; // N 번째에 K 개 선택
        int[][] dp2 = new int[K + 1][N];
        Arrays.fill(dp2[0], 1);
        dp1[1][0] = 1;
        dp1[1][1] = 1;
        dp2[1][1] = 1;

        for (int i = 2; i < N; i++) {
            if (i == N - 1) {
                dp1[K][N - 1] = dp1[K][N - 2];
                for (int j = 1; j <= (i + 1) / 2 && j <= K; j++) {
                    dp2[j][i] = (dp2[j][i - 1] + dp2[j - 1][i - 2]) % divide;
                }
            } else {
                for (int j = 1; j <= (i + 2) / 2 && j <= K; j++) {
                    dp2[j][i] = (dp2[j][i - 1] + dp2[j - 1][i - 2]) % divide;
                    dp1[j][i] = (dp1[j][i - 1] + dp1[j - 1][i - 2]) % divide;
                }
            }
        }
        System.out.println((dp1[K][N - 1] + dp2[K][N - 1]) % divide);
    }
}
