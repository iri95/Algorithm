package lv3;

public class 억억단을외우자 {
    class Solution {
        public int[] solution(int e, int[] starts) {
            int[] answer = new int[starts.length];
            int[] count = new int[e + 1];
            count[1] = 1;
            for(int i = 2; i <= e; i++){
                count[i] += 2;
                for(int j = i * 2; j <= e; j += i) count[j]++;
            }

            int[] max = new int[e + 1];
            max[e] = e;
            for(int i = e - 1; i > 0; i--){
                if(count[i] >= count[max[i+1]]) max[i] = i;
                else max[i] = max[i + 1];
            }

            for(int i = 0; i < starts.length; i++){
                answer[i] = max[starts[i]];
            }

            return answer;
        }
    }
}
