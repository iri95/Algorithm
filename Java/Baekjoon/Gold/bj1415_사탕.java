package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bj1415_사탕 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(br.readLine());
            sum += a;
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        long[] dp = new long[sum + 1];
        dp[0] = 1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (key == 0) continue;

            for (int i = sum; i >= 0; i--) {
                long currentVal = dp[i];
                for (int j = 1; j <= count && i + j * key <= sum; j++) {
                    dp[i + j * key] += currentVal;
                }
            }
        }

        long answer = 0;
        for (int i = 2; i <= sum; i++) {
            if (isPrime(i)) {
                answer += dp[i];
            }
        }
        System.out.println(answer * (map.getOrDefault(0, 0) + 1));
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
