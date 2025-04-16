package lv4;

public class 무지의먹방라이브 {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        int N = food_times.length;
        long div = k / N;
        long remain = k - div * N;
        while (div != 0) {
            for (int i = 0; i < food_times.length; i++) {
                if (food_times[i] == 0) continue;
                if (div >= food_times[i]) {
                    remain += div - food_times[i];
                    food_times[i] = 0;
                    N--;
                } else {
                    food_times[i] -= div;
                }
            }
            if (N == 0) return -1;
            div = remain / N;
            remain -= div * N;
        }

        for (int i = 0; i < food_times.length; i++) {
            if (food_times[i] == 0) continue;
            if (remain == 0) {
                answer = i + 1;
                break;
            }
            remain--;
        }

        return answer;
    }
}
