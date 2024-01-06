package lv2;

import java.util.ArrayList;
import java.util.List;

public class 문자열압축 {
    public static int solution(String s) {
        if (s.length() == 1)return 1;
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++) {
            int cnt = 1;
            List<String> list = new ArrayList<>();
            for (int j = 0; j < s.length(); j = j + i) {
                if (j + i > s.length()) {
                    list.add(s.substring(j, s.length()));
                    break;
                }
                if (list.isEmpty() || !list.get(list.size() - 1).equals(s.substring(j, j + i))) {
                    if (cnt != 1) {
                        list.add(String.valueOf(cnt));
                        cnt = 1;
                    }
                    list.add(s.substring(j, j + i));
                } else {
                    cnt++;
                }

            }
            if (cnt > 1) list.add(String.valueOf(cnt));
            int k = 0;
            for (int j = 0; j < list.size(); j++) {
                k += list.get(j).length();
            }
            answer = Math.min(answer, k);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }
}
