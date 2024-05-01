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
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int MOD = 1000000003;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    int[][] table = initDpTable(N, K);
    // table[N - 1][K] : 1번째 값 더한 경우
    // table[N - 3][K - 1] : N 번쨰 값 더한 경우
    //N을 선택한 경우에는 1과 N-1을 선택할 수 없으므로 [2, N-2]에서 K-1개를 선택하는 것과 같고
    //N을 선택하지 않은 경우에는 [1, N-1]에서 K개를 선택하는 것과 같다
    System.out.println((table[N - 1][K] + table[N - 3][K - 1]) % MOD);
  }
  private static int[][] initDpTable(int N, int K) {
    int[][] table = new int[N + 1][K + 1];

    for (int i = 1; i <= N; i++) {
      table[i][0] = 1;
      table[i][1] = i;
    }

    for (int i = 3; i <= N; i++) {
      for (int j = 2; j <= (i + 1) / 2 && j < K + 1; j++) {
        table[i][j] = (table[i - 1][j] + table[i - 2][j - 1]) % MOD;
      }
    }

    return table;
  }
}
 */