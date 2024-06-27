package lv4;

import java.util.Arrays;

public class 자동완성 {
    public int solution(String[] words) {
        Arrays.sort(words);
        int answer = 0;
        int before = 0;
        int N = words.length;
        for(int i = 0; i < N - 1; i++){
            int next = match(words[i], words[i + 1]);
            answer += Math.max(next < words[i].length() ? next + 1 : next, before + 1);
            before = next;
        }
        answer += before + 1;
        return answer;
    }

    static int match(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length() && i < b.length(); i++){
            if(a.charAt(i) == b.charAt(i)) count++;
            else break;
        }
        return count;
    }
}
