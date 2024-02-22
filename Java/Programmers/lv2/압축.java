package lv2;

import java.util.*;

public class 압축 {
    public static int[] solution(String msg) {
        int[] answer = {};
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        list.add("0");
        for (int i = 0; i < 26; i++) {
            list.add(Character.toString('A' + i));
            set.add(Character.toString('A' + i));
        }
        boolean[] visit = new boolean[msg.length()];
        for (int i = 0; i < msg.length(); i++) {
            if (visit[i]) continue;
            visit[i] = true;
            for (int j = 1; j + i <= msg.length(); j++) {
                if (set.contains(msg.substring(i, i + j))) {
                    if (msg.length() == i + j) {
                        ans.add(list.indexOf(msg.substring(i, i + j)));
                    }
                    visit[i + j - 1] = true;
                } else {
                    list.add(msg.substring(i, i + j));
                    set.add(msg.substring(i, i + j));
                    ans.add(list.indexOf(msg.substring(i, i + j - 1)));
                    break;
                }
            }
        }
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
    }
}
