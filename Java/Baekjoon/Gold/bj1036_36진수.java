package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class bj1036_36진수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] arr = new BigInteger[36];
        for (int i = 0; i < 36; i++) arr[i] = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            int len = a.length();
            for (int j = 0; j < len; j++) {
                int c = a.charAt(j) - '0';
                BigInteger mul = new BigInteger(String.valueOf(36)).pow(len - j - 1);
                if (c > 9) c -= 7;
                arr[c] = arr[c].add(mul.multiply(new BigInteger(String.valueOf(35 - c))));
                sum = sum.add(mul.multiply(new BigInteger(String.valueOf(c))));
            }
        }
        Arrays.sort(arr);
        int K = Integer.parseInt(br.readLine());
        for (int i = 35; i > 35 - K; i--) sum = sum.add(arr[i]);
        StringBuilder answer = new StringBuilder();
        while (true) {
            int a = sum.remainder(new BigInteger("36")).intValue();
            if (a <= 9) answer.insert(0, a);
            else answer.insert(0, (char) (a + 55));
            sum = sum.divide(new BigInteger("36"));
            if (sum.equals(BigInteger.ZERO)) break;
        }

        System.out.println(answer);
    }
}
