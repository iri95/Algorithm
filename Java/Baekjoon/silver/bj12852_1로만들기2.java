package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj12852_1로만들기2 {
    static class Value {
        int k;
        String list;

        Value(int k, String list) {
            this.k = k;
            this.list = list;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Value[] dp = new Value[1000001];
        dp[1] = new Value(0, "1");
        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            int before = 0;
            if (i % 3 == 0) {
                if (min > dp[i / 3].k) {
                    min = dp[i / 3].k;
                    before = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (min > dp[i / 2].k) {
                    min = dp[i / 2].k;
                    before = i / 2;
                }
            }
            if (min > dp[i - 1].k) before = i - 1;

            dp[i] = new Value(dp[before].k + 1, i + " " + dp[before].list);
        }
        System.out.println(dp[N].k);
        System.out.println(dp[N].list);
    }
}
