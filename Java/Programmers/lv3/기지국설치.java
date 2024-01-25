package lv3;

import java.util.ArrayList;
import java.util.List;

public class 기지국설치 {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1;
        int start = 1;
        for (int i : stations) {
            if (i - w > 0 && i - w - start > 0)
                answer += (i - w - start) % range == 0 ? (i - w - start) / range : (i - w - start) / range + 1;
            if (i + w < n) start = i + w + 1;
            else break;
            if (i == stations[stations.length - 1] && i + w < n)
                answer += (n - i - w) % range == 0 ? (n - i - w) / range : (n - i - w) / range + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(11, new int[]{4, 11}, 1));
        System.out.println(solution(16, new int[]{9}, 2));
    }

}
