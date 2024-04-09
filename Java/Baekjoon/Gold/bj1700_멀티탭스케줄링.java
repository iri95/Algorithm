package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1700_멀티탭스케줄링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] order = new int[K];
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> tap = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < K; i++) {
            if (tap.size() < N && !tap.contains(order[i])) tap.add(order[i]);
            else if (!tap.contains(order[i])) {
                int[] count = new int[K + 1];
                for (int j = i; j < K; j++) {
                    if (count[order[j]] == 0) {
                        count[order[j]] = j;
                    }
                }
                int num = 0;
                int maxCount = 0;
                for (int k : tap) {
                    if (count[k] == 0) {
                        num = k;
                        break;
                    } else if (maxCount < count[k]) {
                        maxCount = count[k];
                        num = k;
                    }
                }
                tap.remove((Integer) num);
                tap.add(order[i]);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
