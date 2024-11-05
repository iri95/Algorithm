package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj25378_조약돌 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        boolean[][] can1Work = new boolean[N + 1][N + 1];
        for (int s = 1; s < N; s++) {
            int remain = arr[s];
            for (int e = s + 1; e <= N; e++) {
                if (remain == arr[e]) can1Work[s][e] = true;
                else {
                    can1Work[s][e] = false;
                    if (remain > arr[e]) break;
                }
                remain = arr[e] - remain;
            }
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int e = 2; e <= N; e++) {
            dp[e] = dp[e - 1] + 1;
            for (int s = 1; s < e; s++) {
                if (can1Work[s][e]) dp[e] = Math.min(dp[e], dp[s - 1] + (e - s));
            }
        }

        System.out.println(dp[N]);
    }
}
