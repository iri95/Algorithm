package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj18114_블랙프라이데이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            set.add(list[i]);
            if (set.contains(C)) {
                System.out.println(1);
                return;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                int sum = list[i] + list[j];
                if (sum > C) continue;
                if (sum == C) {
                    System.out.println(1);
                    return;
                }
                int target = C - sum;
                if (target == list[i] || target == list[j]) continue;
                if (set.contains(target)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

}
