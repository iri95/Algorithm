package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3067_coins {
    static int n,k;
    static int[] list;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());

            list = new int[n];
            dp = new int[10001][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list[i] = Integer.parseInt(st.nextToken());
                if(list[i] > 10001)continue;
                dp[list[i]][i]++;
            }
            k = Integer.parseInt(br.readLine());

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
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
