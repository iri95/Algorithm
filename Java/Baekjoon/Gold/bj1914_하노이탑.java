package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bj1914_하노이탑 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        BigInteger bigInteger = BigInteger.TWO.pow(N).subtract(BigInteger.ONE);
        sb.append(bigInteger).append("\n");
        if (N <= 20) hanoi(N, 1, 3, 2);
        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int to, int mid) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, mid, to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, mid, to, from);
    }
}
