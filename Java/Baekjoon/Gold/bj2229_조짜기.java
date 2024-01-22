package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2229_조짜기 {
    static int N;
    static int[] list, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        if (N >= 2) dp[1] = result(0, 1);
        if (N >= 3) dp[2] = result(0, 2);
        for (int i = 3; i < N; i++) {
            dp[i] = result(0, i);
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = Math.max(dp[i], dp[j] + result(j + 1, i));
            }
        }
        System.out.println(dp[N - 1]);
    }

    static int result(int minIndex, int maxIndex) {
        int min = 100001;
        int max = 0;
        for (int i = minIndex; i <= maxIndex; i++) {
            if (list[i] > max) max = list[i];
            if (list[i] < min) min = list[i];
        }
        return Math.abs(max - min);
    }

}
