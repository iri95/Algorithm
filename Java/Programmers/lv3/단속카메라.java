package lv3;

import java.util.*;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int end = -30001;
        for (int[] route : routes) {
            if (end < route[0]) {
                answer++;
                end = route[1];
            } else if (route[1] <= end)
                end = route[1];
        }
        return answer;
    }
}
