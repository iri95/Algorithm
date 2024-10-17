package lv3;

public class 옯기기110 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i = 0; i < s.length; i++){
            if(s[i].length() <= 3) {
                answer[i] = s[i];
                continue;
            }
            StringBuilder sb = new StringBuilder(s[i]);
            int cnt = 0;
            for(int j = 0; j < sb.length() - 2; j++){
                if(sb.substring(j, j + 3).equals("110")){
                    sb.delete(j, j + 3);
                    cnt++;
                    if(j >= 2) j -= 3;
                    else j = -1;
                }
            }
            int c = 0;
            for(int j = sb.length() - 1; j >= 0; j--){
                if(sb.charAt(j) == '0') {
                    c = j + 1;
                    break;
                }
            }
            for(int j = 0; j < cnt; j++) sb.insert(c, "110");
            answer[i] = sb.toString();
        }
        return answer;
    }
}