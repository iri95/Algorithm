package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1744_수묶기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        if (N == 1) {
            System.out.println(list[0]);
            return;
        }
        dp[0] = list[0];
        dp[1] = Math.max(list[1] * list[0], list[1] + list[0]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + list[i - 1] * list[i], dp[i - 1] + list[i]);
        }
        System.out.println(dp[N - 1]);
    }
}
