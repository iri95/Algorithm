package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// https://babyyu0.tistory.com/15
public class bj11066_파일합치기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int K;
        int[] files;
        int[][] dp;
        while (T-- > 0) {
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            files = new int[K + 1];
            dp = new int[K + 1][K + 1];
            for (int i = 1; i <= K; i++) {
                files[i] = files[i - 1] + Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                dp[i][i] = 0;
            }
            for (int i = 1; i <= K; i++) {
                for (int j = i - 1; 1 <= j; j--) {
                    if(i - j == 1) {
                        dp[j][i] = Math.min(files[i] - files[j - 1], dp[j][i]);
                        continue;
                    }
                    for (int k = j; k < i; k++)
                        dp[j][i] = Math.min(dp[j][k] + dp[k + 1][i] + files[k] - files[j - 1] + files[i] - files[k], dp[j][i]);
                }
            }
            sb.append(dp[1][K]).append("\n");
        }
        System.out.println(sb);
    }
}
