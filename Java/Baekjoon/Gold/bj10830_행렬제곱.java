package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10830_행렬제곱 {
    static int MOD = 1_000, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                A[i][j] = Integer.parseInt(st.nextToken()) % MOD;
        }
        int[][] answer = sol(B, A);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                sb.append(answer[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] mulMatrix(int[][] a, int[][] b) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++)
                    result[i][j] += (a[i][k] * b[k][j]) % MOD;
                result[i][j] %= MOD;
            }
        }
        return result;
    }

    private static int[][] sol(long n, int[][] a) {
        if (n == 1) return a;
        int[][] m = sol(n / 2, a);
        m = mulMatrix(m, m);
        if (n % 2 == 1) return mulMatrix(m, a);
        else return m;
    }
}
