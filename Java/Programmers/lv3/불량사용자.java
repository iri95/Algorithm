package lv3;

import java.util.HashSet;
import java.util.Set;

// SET을 이용할까? -> 비트로 방문 체크해서 넣기
public class 불량사용자 {
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        boolean[][] visit = new boolean[user_id.length][banned_id.length];
        for (int i = 0; i < user_id.length; i++) {
            for (int j = 0; j < banned_id.length; j++) {
                if (user_id[i].length() != banned_id[j].length()) continue;
                boolean can = true;
                for (int k = 0; k < user_id[i].length(); k++) {
                    if (banned_id[j].charAt(k) == '*') continue;
                    if (user_id[i].charAt(k) != banned_id[j].charAt(k)) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    visit[i][j] = true;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        re(banned_id.length, 0, visit, new boolean[user_id.length], set);
        return set.size();
    }

    static void re(int ban_index, int count, boolean[][] visit, boolean[] visited, Set<Integer> set) {
        if (count == ban_index) {
            int a = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    a = a | 1 << i;
                }
            }
            set.add(a);
            return;
        }
        for (int i = 0; i < visit.length; i++) {
            if (visited[i])continue;
            if (visit[i][count]) {
                visited[i] = true;
                re(ban_index, count + 1, visit, visited, set);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }
}
