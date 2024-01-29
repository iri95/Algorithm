package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 참고 : https://www.acmicpc.net/board/view/82054
public class bj4781_사탕가게 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            float mFloat = Float.parseFloat(st.nextToken());
            int m = (int) (mFloat * 100 + 0.5);
            if (n == 0 && m == 0.00) break;
            int[] dp = new int[m + 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int) (Float.parseFloat(st.nextToken()) * 100 + 0.5);
                for (int j = p; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }
}
