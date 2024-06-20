package lv2;

public class 점찍기 {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i = 0; i * k <= d; i++){
            int y = (int) Math.sqrt(Math.pow(d,2) - Math.pow(i * k, 2));
            answer += y / k + 1;
        }
        return answer;
    }
}
