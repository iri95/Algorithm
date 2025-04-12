package lv3;

import java.util.*;

public class 여행경로 {
    static int len;
    static Map<String, List<String>> map = new HashMap<>(); // 경로를 저장하는 Map
    static Map<String, boolean[]> visited = new HashMap<>(); // 방문 처리를 하는 Map

    public String[] solution(String[][] tickets) {
        len = tickets.length;

        for (int i = 0; i < len; i++) {
            if (!map.containsKey(tickets[i][0]))
                map.put(tickets[i][0], new ArrayList<>());

            map.get(tickets[i][0]).add(tickets[i][1]);
        }

        for (Map.Entry<String, List<String>> m : map.entrySet()) {
            visited.put(m.getKey(), new boolean[m.getValue().size()]);
            Collections.sort(m.getValue());
        }

        String[] answer = new String[len + 1];
        dfs("ICN", 0, answer);
        return answer;

    }

    private static boolean dfs(String start, int index, String[] answer) {
        answer[index] = start;
        if (index == len) return true;

        if (map.get(start) == null) return false;

        for (int i = 0; i < map.get(start).size(); i++) {
            if (visited.get(start)[i]) continue;

            visited.get(start)[i] = true;
            if (dfs(map.get(start).get(i), index + 1, answer)) return true;
            visited.get(start)[i] = false;
        }

        return false;
    }
}
