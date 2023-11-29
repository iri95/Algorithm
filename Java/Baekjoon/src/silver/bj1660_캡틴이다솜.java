package Baekjoon.src.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj1660_캡틴이다솜 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int k = 0;
        int cnt = 0;
        int cnt2 = 0;
        do {
            k++;
            cnt += k;
            cnt2 += cnt;
            list.add(cnt2);
        } while (N >= cnt2);

        int cnt3 = 1;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= N ; i++) {
            if (i == list.get(cnt3)) {
                dp[i] = 1;
                cnt3++;
            }else{
                for (int j = 1; j < cnt3; j++) {
                    dp[i] = Math.min(dp[i - list.get(j)] + 1, dp[i]);
                }
            }
        }
        System.out.println(dp[N]);
    }
}
