package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 초과
public class bj1943_동전분배 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < 3; T++) {
            int n = Integer.parseInt(br.readLine());
            int[] count = new int[n];
            int[] account = new int[n];
            int sum = 0;
            boolean[] dp = new boolean[100001];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                account[i] = Integer.parseInt(st.nextToken());
                count[i] = Integer.parseInt(st.nextToken());
                sum += account[i] * count[i];
                for (int j = 0; j < count[i]; j++) {
                    dp[account[i] * j] = true;
                }
            }
            if (sum % 2 == 1) {
                sb.append(0).append("\n");
                continue;
            } else if (dp[sum / 2]) {
                sb.append(1).append("\n");
                continue;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < count[i]; j++) {
                    for (int k = sum / 2; k - account[i] >= 0; k--) {
                        if (dp[k - account[i]]) {
                            dp[k] = true;
                        }
                    }
                }
            }

            if (dp[sum / 2]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
