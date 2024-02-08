package lv3;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 셔틀버스 {
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] list = new int[timetable.length];
        for (int i = 0; i < list.length; i++) {
            String str = timetable[i];
            StringTokenizer st = new StringTokenizer(str, ":");
            list[i] += Integer.parseInt(st.nextToken()) * 60;
            list[i] += Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        // 0900 : 540
        int start = 540;
        int index = 0;
        int result = 0;
        while (n-- > 0) {
            int count = 0;
            if (n == 0) {
                while (count < m - 1) {
                    if (list[index] <= start) {
                        count++;
                        index++;
                    } else break;
                }
                if (index < list.length) {
                    if (list[index] <= start)
                        result = list[index] - 1;
                    else result = start;
                } else result = start;
            } else {
                while (count < m) {
                    if (list[index] <= start) {
                        count++;
                        index++;
                    } else break;
                }
                start += t;
            }
        }
        String H = String.valueOf(result / 60);
        String M = String.valueOf(result % 60);
        if (H.length() == 1) H = "0" + H;
        if (M.length() == 1) M = "0" + M;
        answer = H + ":" + M;
        return answer;
    }

    public static void main(String[] args) {
        // "09:00"
        System.out.println(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        // "09:09"
        System.out.println(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        // "08:59"
        System.out.println(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        // "00:00"
        System.out.println(solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        // "09:00"
        System.out.println(solution(1, 1, 1, new String[]{"23:59"}));
        // "18:00"
        System.out.println(solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }
}
