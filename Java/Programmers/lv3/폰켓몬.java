package lv3;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        int max = N / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            answer++;
            if (answer >= max) break;
        }

        return answer;
    }
}
