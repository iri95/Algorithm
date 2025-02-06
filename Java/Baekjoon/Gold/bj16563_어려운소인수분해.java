package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16563_어려운소인수분해 {
    static int[] prime = new int[5_000_001];

    public static void main(String[] args) throws Exception {
        findPrime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(st.nextToken());
            do {
                sb.append(prime[k]).append(" ");
                k /= prime[k];
            } while (k != 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void findPrime() {
        for (int i = 0; i <= 5_000_000; i++) prime[i] = i;

        int sqrt = (int) Math.sqrt(5_000_000);
        for (int i = 2; i <= sqrt; i++) {
            if (prime[i] != i) continue;
            for (int j = i * i; j <= 5_000_000; j += i)
                if (prime[j] == j) prime[j] = i;
        }
    }
}