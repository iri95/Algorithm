package lv3;

public class 거스름돈 {
    public int solution(int n, int[] money) {
        int INF = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int coin : money){
            for(int i = 1; i <= n; i++){
                if(i - coin < 0) continue;
                dp[i] += dp[i - coin];
                dp[i] %= INF;
            }
        }
        return dp[n];
    }
}
