package lv1;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 가장많이받은선물 {
    static class Friend {
        int gCount = 0;
        int rCount = 0;
        int GR = 0;
        Map<String, Integer> give = new HashMap<>();
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Friend> map = new HashMap<>();
        for (String friend : friends) {
            map.put(friend, new Friend());
            for (String f : friends) {
                if (f.equals(friend)) continue;
                map.get(friend).give.put(f, 0);
            }
        }
        for (String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            String GF = st.nextToken(); // 준 친구
            String RF = st.nextToken(); // 받은 친구
            map.get(GF).give.put(RF, map.get(GF).give.get(RF) + 1);
            map.get(GF).gCount++;
            map.get(RF).rCount++;
        }
        for (String friend : friends) {
            map.get(friend).GR = map.get(friend).gCount - map.get(friend).rCount;
        }
        for (String me : friends) {
            int count = 0;
            for (String friend : friends) {
                if (me.equals(friend)) continue;
                if (map.get(me).give.get(friend).equals(map.get(friend).give.get(me))) {
                    if (map.get(me).GR > map.get(friend).GR) count++;
                } else if (map.get(me).give.get(friend) > map.get(friend).give.get(me)) count++;
            }
            answer = Math.max(count, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
        System.out.println(solution(new String[]{"joy", "brad", "alessandro", "conan", "david"}, new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}));
        System.out.println(solution(new String[]{"a", "b", "c"}, new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}));
    }
}
