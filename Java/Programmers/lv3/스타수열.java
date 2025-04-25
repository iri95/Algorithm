package lv3;

import java.util.*;

public class 스타수열 {
    public int solution(int[] a) {
        int answer = -1;
        int[] count = new int[a.length];

        for (int c : a)
            count[c]++;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++)
            if (count[i] != 0)
                list.add(new int[]{i, count[i]});

        list.sort((o1, o2) -> o2[1] - o1[1]);

        for (int[] n : list) {
            if (n[1] * 2 <= answer) break;
            // -1 : n이외의 값이 와야하는 경우, 0 : n이 와야하는 경우, 1 : 아무거나 와도 되는 경우
            int flag = 1;
            int cnt = 0;
            for (int i : a) {
                if (i == n[0]) {
                    if (flag == 0) {
                        cnt += 2;
                        flag = 1;
                    } else
                        flag = -1;
                } else {
                    if (flag == -1) {
                        cnt += 2;
                        flag = 1;
                    } else
                        flag = 0;
                }
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
