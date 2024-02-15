package lv2;

import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {
    public static String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> map = new HashMap<>();
        String[][] strs = new String[record.length][3];
        int count = 0;
        for (int i = 0; i < record.length; i++) {
            strs[i] = record[i].split(" ");
            if (strs[i][0].equals("Enter") || strs[i][0].equals("Leave")) count++;
            if (strs[i][0].equals("Enter") || strs[i][0].equals("Change")) {
                map.put(strs[i][1], strs[i][2]);
            }
        }
        answer = new String[count];
        int i = 0;
        for (String[] str : strs) {
            if (str[0].equals("Change")) continue;
            answer[i] = map.get(str[1]) + "님이 ";
            if (str[0].equals("Enter")) answer[i] += "들어왔습니다.";
            else if (str[0].equals("Leave")) answer[i] += "나갔습니다.";
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}));
    }

}
