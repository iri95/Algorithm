package lv2;

import java.util.Arrays;

public class 가장큰수 {
    public static String solution(int[] numbers){
        String[] list = new String[numbers.length];
        long sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            list[i] = String.valueOf(numbers[i]);
            sum += numbers[i];
        }
        if (sum == 0) return "0";
        Arrays.sort(list, (o1, o2) -> {
            long value1 = Long.parseLong(o1 + o2);
            long value2 = Long.parseLong(o2 + o1);
            if (value1 > value2) return -1;
            else if(value1 < value2) return 1;
            else return 0;
        });
        String answer = "";
        for (int i = 0; i < list.length; i++) {
            answer += list[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6,10,2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution(new int[]{0,0,0}));
    }
}
