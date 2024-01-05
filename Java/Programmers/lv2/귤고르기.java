package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 귤고르기 {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{tangerine[0], 1});
        for (int i = 1; i < tangerine.length; i++) {
            if (list.get(list.size() - 1)[0] == tangerine[i]) {
                list.get(list.size() - 1)[1]++;
            }else{
                list.add(new int[]{tangerine[i], 1});
            }
        }
        Collections.sort(list, ((o1, o2) -> o2[1] - o1[1]));
        while (0 < k) {
            k -= list.get(answer)[1];
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));

    }
}
