package lv2;

import java.util.ArrayList;
import java.util.List;

public class 뉴스클러스터링 {
    public static int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.charAt(i) < 'A' || str1.charAt(i) >'Z') continue;
            if (str1.charAt(i + 1) < 'A' || str1.charAt(i + 1) >'Z') {
                i++;
                continue;
            }
            str1List.add(str1.substring(i, i + 2));
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if (str2.charAt(i) < 'A' || str2.charAt(i) >'Z') continue;
            if (str2.charAt(i + 1) < 'A' || str2.charAt(i + 1) >'Z') {
                i++;
                continue;
            }
            str2List.add(str2.substring(i, i + 2));
        }
        boolean[] visit = new boolean[str2List.size()];
        double count = 0;
        for (int i = 0; i < str1List.size(); i++) {
            for (int j = 0; j < str2List.size(); j++) {
                if (visit[j]) continue;
                if (str1List.get(i).equals(str2List.get(j))) {
                    visit[j] = true;
                    count++;
                    break;
                }
            }
        }
        if (str1List.size() + str2List.size() - count != 0)
            answer = (int) (count / (str1List.size() + str2List.size() - count) * 65536);
        else answer = 65536;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }
}
