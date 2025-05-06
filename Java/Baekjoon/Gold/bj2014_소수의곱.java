package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2014_소수의곱 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] primes = new long[K];
        for (int i = 0; i < K; i++)
            primes[i] = Long.parseLong(st.nextToken());

        long[] dp = new long[N + 1]; // 해당 번째의 값을 저장하는 배열
        int[] idx = new int[K]; // 소수와 곱할 dp값의 index를 저장하는 배열, 소순는 dp의 앞부터 차례대로 곱해야 한다.
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            long next = Long.MAX_VALUE;
            for (int j = 0; j < K; j++) {
                long value = primes[j] * dp[idx[j]];
                if (value < next)
                    next = value;
            }
            dp[i] = next;

            for (int j = 0; j < K; j++) {
                if (primes[j] * dp[idx[j]] == next)
                    idx[j]++;
            }
        }

        System.out.println(dp[N]);
    }
}
