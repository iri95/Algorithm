package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1423_원숭이키우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] num = new long[N];
        long[] power = new long[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(br.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st1.nextToken());
            power[i] = Integer.parseInt(st2.nextToken());
            sum += num[i] * power[i];
            num[i] = Math.min(D, num[i]);
        }
        long[] dp = new long[D+1];
        for (int i = 0; i < N - 1; i++) {
            while(num[i]-- > 0){
                for (int j = D; j >= 0; j--) {
                    for (int k = i + 1; k < N && j + k - i <= D; k++) {
                        dp[j + k - i] = Math.max(dp[j + k - i], dp[j] + power[k] - power[i]);
                    }
                }
            }
        }
        System.out.println(dp[D] + sum);

    }

}
