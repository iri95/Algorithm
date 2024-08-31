package lv2;

import java.util.*;

public class 모음사전 {
    static List<String> list = new ArrayList<>();
    public int solution(String word) {
        sol("");
        Collections.sort(list);
        int answer = list.indexOf(word) + 1;
        return answer;
    }

    private static void sol(String str){
        if(str.length() == 5) return;
        for(int i = 0; i < 5; i++){
            String a = str + "AEIOU".charAt(i);
            list.add(a);
            sol(a);
        }
    }
}
