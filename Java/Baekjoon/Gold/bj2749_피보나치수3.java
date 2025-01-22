package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2749_피보나치수3 {
    static long MOD = 1_000_000L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.println(fibonacci(N)[0][1]);
    }

    private static long[][] mul(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        result[0][0] = (a[0][0] * b[0][0] % MOD + a[0][1] * b[1][0] % MOD) % MOD;
        result[1][0] = (a[1][0] * b[0][0] % MOD + a[1][1] * b[1][0] % MOD) % MOD;
        result[0][1] = (a[0][0] * b[0][1] % MOD + a[0][1] * b[1][1] % MOD) % MOD;
        result[1][1] = (a[1][0] * b[0][1] % MOD + a[1][1] * b[1][1] % MOD) % MOD;
        return result;
    }

    private static long[][] fibonacci(long n) {
        if (n == 1) return new long[][]{{1, 1}, {1, 0}};
        long[][] temp = fibonacci(n / 2);
        temp = mul(temp, temp);
        if (n % 2 == 1) return mul(temp, fibonacci(1));
        else return temp;
    }

}
