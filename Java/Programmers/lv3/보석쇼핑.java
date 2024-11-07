package lv3;

import java.util.*;

public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int N = gems.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) set.add(gems[i]);
        int size = set.size();
        set.clear();
        if (size == 1) return new int[]{1, 1};

        Map<String, Integer> map = new HashMap<>();
        int s = 0;
        int e = 0;
        int len = N + 1;
        while (e < N) {
            set.add(gems[e]);
            map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);
            while (e != s && map.get(gems[s]) > 1) {
                map.put(gems[s], map.get(gems[s]) - 1);
                s++;
            }
            e++;
            if (set.size() == size && len > e - s) {
                len = e - s;
                answer[0] = s + 1;
                answer[1] = e;
            }

        }
        return answer;
    }
}
