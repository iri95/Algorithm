package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11722_가장긴감소하는부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[N];
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = Math.max(dp[i], list[j] > list[i] ? dp[j] + 1 : 1);
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}

