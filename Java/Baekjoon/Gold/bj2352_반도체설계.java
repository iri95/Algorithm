package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2352_반도체설계 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0 ; j--)
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);

    }
}
