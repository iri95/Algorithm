package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj7570_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[N + 1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[num] = dp[num - 1] + 1;
            max = Math.max(dp[num], max);
        }
        System.out.println(N - max);
    }
}
