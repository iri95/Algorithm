package lv4;

public class 도둑질 {
    public int solution(int[] money) {
        int N = money.length;
        int answer = 0;
        int[] dp1 = new int[N]; // 첫번쨰 집을 턴 집
        int[] dp2 = new int[N]; // 첫번째 집을 안 턴 집
        dp1[0] = money[0];
        dp2[1] = money[1];
        dp1[2] = money[2] + dp1[0];
        dp2[2] = money[2];
        for(int i = 3; i < N; i++){
            dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 3] + money[i]);
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 3] + money[i]);
        }
        answer = Math.max(dp1[N - 2], dp1[N - 3]);
        answer = Math.max(dp2[N - 1], Math.max(dp2[N - 2], answer));

        return answer;
    }
}
