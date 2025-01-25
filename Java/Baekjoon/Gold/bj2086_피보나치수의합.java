package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2086_피보나치수의합 {
    /*
    f(n) = f(n - 1) + f(n - 2) = f(n + 2) - f(n - 1)
    F(n) = 시그마(f(n)) = 시그마(f(n + 2) - f(n - 1));
    F(n) = f(n + 2) - f(2)
    따라서, F(b) - F(a - 1) = F(b + 2) - F(a + 1);
     */
    static long MOD = 1_000_000_000L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong((st.nextToken()));
        long b = Long.parseLong((st.nextToken()));
        System.out.println((MOD + fibonacci(b + 2)[0][1] - fibonacci(a + 1)[0][1]) % MOD);
    }

    private static long[][] mulMatrix(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++)
                    result[i][j] += a[i][k] * b[k][j];
                result[i][j] %= MOD;
            }
        }
        return result;
    }

    private static long[][] fibonacci(long n) {
        if (n == 1) return new long[][]{{1, 1}, {1, 0}};
        long[][] matrix = fibonacci(n / 2);
        matrix = mulMatrix(matrix, matrix);
        if (n % 2 == 1) matrix = mulMatrix(matrix, fibonacci(1));
        return matrix;
    }
}
