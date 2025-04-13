package lv3;
import java.util.*;

public class N으로표현 {
    public int solution(int N, int number) {
        if(N == number) return 1;

        Set<Integer>[] dp = new HashSet[9];
        for(int i = 0; i < 9; i++)
            dp[i] = new HashSet<>();

        dp[1].add(N);
        for(int i = 2; i <= 8; i++){
            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));

            for(int j = 1; j < i; j++){
                int k = i - j;
                for(int a : dp[j]){
                    for(int b : dp[k]){
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if(b != 0){
                            dp[i].add(a / b);
                        }
                    }
                }
            }
            if(dp[i].contains(number))
                return i;
        }

        return -1;
    }
}
