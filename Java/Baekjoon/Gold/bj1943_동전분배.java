package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1943_동전분배 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < 3; T++) {
            int n = Integer.parseInt(br.readLine());
            int[] count = new int[n];
            int[] account = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                account[i] = Integer.parseInt(st.nextToken());
                count[i] = Integer.parseInt(st.nextToken());
                sum += account[i] * count[i];
            }
            if (sum % 2 != 0) {
                sb.append(0).append("\n");
                continue;
            }

            boolean[] dp = new boolean[sum / 2 + 1];
            dp[0] = true;

            int[] cnt = new int[sum / 2 + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cnt, 0);
                for (int k = 0; k + account[i] <= sum / 2; k++) {
                    if (dp[k + account[i]]) continue;
                    if (dp[k] && cnt[k] < count[i]) {
                        dp[k + account[i]] = true;
                        cnt[k + account[i]] = cnt[k] + 1;
                    }
                }
            }

            if (dp[sum / 2]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}
