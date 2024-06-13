package lv2;

import java.util.Arrays;

public class 시소짝궁 {
    public long solution(int[] weights) {
        long answer = 0;
        int n = weights.length;
        int[] count = new int[1001];
        Arrays.sort(weights);
        for (int now : weights) {
            for (int j = 100; j <= now; j++) {
                if (count[j] == 0) continue;
                if (now == j || now * 2 == j * 3 || now * 2 == j * 4 || now * 3 == j * 4) answer += count[j];
            }
            count[now]++;
        }
        return answer;
    }
}
