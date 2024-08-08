package lv2;

public class 숫자블록 {
    class Solution {
        public int[] solution(long begin, long end) {
            int[] answer = new int[(int) (end - begin + 1)];
            for (int i = 0; i < answer.length; i++) {
                int n = (int) (i + begin);
                for (int div = 2; div <= Math.sqrt(n); div++) {
                    if (n % div == 0) {
                        if (n / div > 10_000_000) {
                            answer[i] = div;
                            continue;
                        }
                        answer[i] = n / div;
                        break;
                    }
                }
                if (answer[i] == 0) answer[i] = 1;
            }
            if (begin == 1) answer[0] = 0;
            return answer;
        }
    }
}
