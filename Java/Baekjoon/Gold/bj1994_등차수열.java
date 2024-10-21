package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1994_등차수열 {
    static int N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];
        arr[0] = -1;
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int answer = 1;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                dp[i][j] = 2;
                int pre = 2 * arr[i] - arr[j];
                int s = 0;
                int e = i - 1;
                while(s < e){
                    int m = (s + e) / 2;
                    if (arr[m] < pre) s = m + 1;
                    else if (arr[m] == pre && arr[e] == pre) s = m + 1;
                    else e = m;
                }
                if (arr[e] == pre) dp[i][j] = Math.max(dp[i][j], dp[e][i] + 1);
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer);
    }
}
