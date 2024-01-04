package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://velog.io/@jslog/BOJ-%EB%B0%B1%EC%A4%80-2023%EB%B2%88-%EC%8B%A0%EA%B8%B0%ED%95%9C-%EC%86%8C%EC%88%98-%EC%9E%90%EB%B0%94-JAVA-1
public class bj2023_신기한소수 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        getResult(0, n);
        System.out.println(sb);
    }

    public static void getResult(int output, int n) {
        if (n == 0) {
            if (isPrime(output)) sb.append(output).append("\n");
            return;
        }
        for (int i = 0; i < 10; i++) {
            int next = output * 10 + i;
            if (isPrime(next)) getResult(next, n - 1);
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
