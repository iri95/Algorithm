package lv3;

import java.util.StringTokenizer;

public class 광고삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int N = logs.length;
        int play = stringToInt(play_time);
        int adv = stringToInt(adv_time);
        long[] times = new long[play + 1];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(logs[i], "-");
            int start = stringToInt(st.nextToken());
            int end = stringToInt(st.nextToken());
            for(int j = start; j < end; j++) times[j]++;
        }

        long sum = 0;
        for(int i = 0; i < adv; i++){
            sum += times[i];
        }

        long max = sum;
        int maxS = 0;
        int start = 0;
        for(int i = adv; i <= play; i++){
            sum += times[i];
            sum -= times[start++];
            if(max < sum){
                maxS = start;
                max = sum;
            }
        }

        return intToString(maxS);
    }

    static int stringToInt(String str){
        String[] strs = str.split(":");
        return Integer.parseInt(strs[0]) * 3600 + Integer.parseInt(strs[1]) * 60 + Integer.parseInt(strs[2]);
    }

    static String intToString(int time){
        String H = time / 3600 < 10 ? "0" + time / 3600 : (time / 3600) + "";
        time %= 3600;
        String M = time / 60 < 10 ? "0" + time / 60 : time / 60 + "";
        time %= 60;
        String S = time < 10 ? "0" + time : time + "";
        return H + ":" + M + ":" + S;
    }
}
