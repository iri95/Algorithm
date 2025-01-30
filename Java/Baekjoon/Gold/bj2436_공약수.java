package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2436_공약수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long AB = A * B;
        long a = B;
        long b = B;
        for (int i = 2; i <= Math.sqrt(AB); i++) {
            if (B % i == 0) {
                long x = i;
                long y = AB / i;
                if (!GCD(x, y, A)) continue;
                if (x + y < a + b) {
                    a = x;
                    b = y;
                }
            }
        }
        System.out.println(a + " " + b);
    }

    private static boolean GCD(long a, long b, long gcd) {
        while (a != 0) {
            long temp = b;
            b = a;
            a = temp % a;
        }
        return b == gcd;
    }
}
