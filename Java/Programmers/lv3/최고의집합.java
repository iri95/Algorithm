package lv3;

import java.util.Arrays;

public class 최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (n > s) return new int[]{-1};
        Arrays.fill(answer, s / n);
        for (int i = 0; i < s % n; i++)
            answer[n - 1 - i]++;

        return answer;
    }
}
