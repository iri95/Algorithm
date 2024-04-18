package lv2;

import java.util.Arrays;

public class 광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int N = minerals.length;
        int[][] list = new int[N / 5 + (N % 5 == 0 ? 0 : 1)][3];
        int sum = picks[0] + picks[1] + picks[2];
        int index = 0;
        for (int i = 0; i < N && i < sum * 5; i++) {
            list[index][0]++;
            list[index][1]++;
            list[index][2]++;
            if (minerals[i].equals("diamond")) {
                list[index][1] += 4;
                list[index][2] += 24;
            } else if (minerals[i].equals("iron")) {
                list[index][2] += 4;
            }
            if (i % 5 == 4) index++;
        }
        Arrays.sort(list, (o1, o2) -> o2[2] - o1[2]);
        for (int[] li : list) {
            if (picks[0] > 0) {
                answer += li[0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += li[1];
                picks[1]--;
            } else {
                answer += li[2];
                picks[2]--;
            }
        }

        return answer;
    }
}
