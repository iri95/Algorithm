package lv3;

import java.util.Arrays;

public class 인사고과 {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] wanScore = scores[0];
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        int max = 0;
        for(int[] score : scores){
            if(score[1] < max){
                if(Arrays.equals(wanScore, score)) return -1;
            }else {
                max = score[1];
                if(wanScore[0] + wanScore[1] < score[0] + score[1]) answer++;
            }
        }
        return answer;
    }
}
