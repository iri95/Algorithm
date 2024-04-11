package lv2;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 과제진행하기 {
    static class Work implements Comparable<Work>{
        String name;
        int start;
        int playTime;

        public Work(String name, int start, int playTime){
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        public int compareTo(Work o){
            return this.start - o.start;
        }
    }

    public static String[] solution(String[][] plans) {
        int N = plans.length;
        String[] answer = new String[N];
        Work[] works = new Work[plans.length];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(plans[i][1], ":");
            works[i] = new Work(plans[i][0],Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()) , Integer.parseInt(plans[i][2]));
        }
        Arrays.sort(works);
        Stack<Work> stack = new Stack<>();
        int index = 0;
        Work play = works[0];
        for(int i = 1; i < N; i++){
            if(works[i].start - play.start >= play.playTime) {
                answer[index++] = play.name;
                int remain = works[i].start - play.start - play.playTime ;
                while(!stack.isEmpty() && remain > 0){
                    Work w = stack.pop();
                    if(remain >= w.playTime){
                        remain -= w.playTime;
                        answer[index++] = w.name;
                    }else{
                        w.playTime -= remain;
                        remain = 0;
                        stack.push(w);
                    }
                }
            }else{
                play.playTime -= works[i].start - play.start;
                stack.push(play);
            }
            play = works[i];
        }
        answer[index++] = works[N - 1].name;
        while(!stack.isEmpty()){
            answer[index++] = stack.pop().name;
        }

        return answer;
    }
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}})));
//        System.out.println(Arrays.toString(solution(new String[][]{{"A", "12:00", "30"}, {"B", "12:10", "20"}, {"C", "15:00", "40"}, {"D", "15:10", "30"}})));
    }
}
