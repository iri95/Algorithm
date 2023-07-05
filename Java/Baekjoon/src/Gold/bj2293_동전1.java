package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2293_동전1 {
    static int n,k;
    static int[] list;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new int[n];
        dp = new int[10001][n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
            if(list[i] > 10001)continue;
            dp[list[i]][i]++;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i - list[j] > 0) {
                    for (int l = j; l < n; l++) {
                        dp[i][j] += dp[i-list[j]][l];
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += dp[k][i];
        }
        System.out.println(result);
    }
}
