package lv3;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        long s = 0;
        long e = Long.MAX_VALUE;
        while(s < e){
            long m = (s + e) / 2;
            long result = sol(m, n, times);
            if(result < n) s = m + 1;
            else e = m;
        }
        answer = e;
        return answer;
    }

    private static long sol(long t,int target, int[] times){
        long result = 0;
        for(int i = 0; i < times.length; i++){
            result += t / (long)times[i];
            if(target <= result) break;
        }
        return result;
    }
}
