package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj17425_약수의합 {
    static long[] result = new long[1_000_001];

    public static void main(String[] args) throws Exception {
        start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(result[N]).append("\n");
        }
        System.out.println(sb);
    }

    private static void start() {
        Arrays.fill(result, 1);
        for (int i = 2; i < 1_000_001; i++) {
            result[i] += result[i - 1];
            for (int j = i; j < 1_000_001; j += i) result[j] += i;
        }
    }
}
