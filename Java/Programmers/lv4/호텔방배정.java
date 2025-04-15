package lv4;

import java.util.*;

public class 호텔방배정 {
    static Map<Long, Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }

        return answer;
    }

    private static long findRoom(long n) {
        if (!map.containsKey(n)) {
            map.put(n, n + 1);
            return n;
        }

        map.put(n, findRoom(map.get(n)));
        return map.get(n);
    }
}
