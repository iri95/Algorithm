package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2229_조짜기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 2; i <= N; i++) {
            int min = list[i];
            int max = list[i];
            for (int j = i - 1; j >= 0; j--) {
                if (max < list[j + 1]) max = list[j + 1];
                if (min > list[j + 1]) min = list[j + 1];
                dp[i] = Math.max(dp[i], dp[j] + max - min);
            }
        }
        System.out.println(dp[N]);
    }
}
