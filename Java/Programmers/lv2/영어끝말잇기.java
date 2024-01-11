package lv2;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        int turn = 1;
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            int number = i % n + 1;
            if (number - 1 == 0) turn++;
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0) || list.contains(words[i])) {
                answer = new int[]{number, turn};
                break;
            }
            list.add(words[i]);
        }
        if (answer.length == 0) {
            return new int[]{0, 0};
        } else {
            return answer;
        }
    }
}
