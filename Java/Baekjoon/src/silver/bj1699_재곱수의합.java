package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj1699_재곱수의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int k = 0;
        int cnt = 0;
        do {
            k++;
            cnt = k * k;
            list.add(cnt);
        } while (N >= cnt);

        int cnt2 = 1;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= N ; i++) {
            if (i == list.get(cnt2)) {
                dp[i] = 1;
                cnt2++;
            }else{
                for (int j = 1; j < cnt2; j++) {
                    dp[i] = Math.min(dp[i - list.get(j)] + 1, dp[i]);
                }
            }
        }
        System.out.println(dp[N]);
    }

}
