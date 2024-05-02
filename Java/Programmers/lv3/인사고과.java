package lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 인사고과 {
    public int solution(int[][] scores) {
        int answer = -1;
        int wan = scores[0][0] + scores[0][1];
        int[] wanScore = scores[0];
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]) return o2[1] - o1[1];
            return o2[0] - o1[0];
        });

        List<Integer> list = new ArrayList<>();
        list.add(scores[0][0] + scores[0][1]);
        int[] max = {0, 0};
        int[] before = scores[0];
        for(int i = 1; i < scores.length; i++){
            if(scores[i][0] != before[0]) max = before[1] > max[1] ? before : max;
            if(max[1] > scores[i][1]) {
                if(wanScore == scores[i]) return -1;
                continue;
            }

            list.add(scores[i][0] + scores[i][1]);
            if(scores[i][0] != before[0]) before = scores[i];
            else if(before[1] < scores[i][1]) before = scores[i];
        }
        list.sort(Collections.reverseOrder());
        answer = list.indexOf(wan) + 1;
        return answer;
    }
}
