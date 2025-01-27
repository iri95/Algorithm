package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj11442_홀수번째피보나치수의합 {
    /*
    f(n) = f(n - 1) + f(n - 2) = f(n + 2) - f(n + 1)
    F(n) = 시그마(f(n)) = 시그마(f(n + 2) - f(n - 1));
    1번 공식 : F(n) = f(n + 2) - f(2)

    홀수 만을 더하는 경우.
    f(n) = f(n - 1) + f(n - 2)
    f(n) + f(n - 2) + ... + f(2) + f(0) = f(n - 1) + f(n - 2) + f(n - 3) ... f(1) + f(1)
    즉, F(n - 1) + 1이 된다.
    즉, 홀수의 합은 n이 홀수일 때 F(n - 1) + 1, 짝수일 때 F(n - 2) + 1가 된다.
    그리고 위의 1번 공식을 사용하면 n이 홀수일 때 f(n + 1), 짝수일 때 f(n)이 결과가 된다.
     */
    static long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println((MOD + fibonacci(n % 2 == 1 ? n + 1 : n)[0][1]) % MOD);
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
