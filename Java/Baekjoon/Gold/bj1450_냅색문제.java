package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1450_냅색문제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        long answer = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            if (list[i] <= C) answer++;
        }
        if (N == 1) {
            System.out.println(answer);
            return;
        }
        Arrays.sort(list);
        List<Integer> front = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for (int i = 0; i < N / 2; i++) {
            int size = front.size();
            for (int j = 0; j < size; j++) {
                int sum = front.get(j) + list[i];
                if (sum < C) front.add(sum);
                if (sum <= C) answer++;
            }
            front.add(list[i]);
        }
        for (int i = N / 2; i < N; i++) {
            int size = end.size();
            for (int j = 0; j < size; j++) {
                int sum = end.get(j) + list[i];
                if (sum < C) end.add(sum);
                if (sum <= C) answer++;
            }
            end.add(list[i]);
        }
        Collections.sort(front);
        Collections.sort(end);
        int e = end.size() - 1;
        while (e >= 0) {
            int eIndex = e;
            int cnt = 0;
            while (eIndex >= 0) {
                if (Objects.equals(end.get(eIndex), end.get(e))) {
                    cnt++;
                    eIndex--;
                } else break;
            }
            answer += (long) cnt * binary(C - end.get(e), front);
            e = eIndex;
        }
        System.out.println(answer);
    }

    static int binary(int target, List<Integer> list) {
        int s = 0;
        int e = list.size();
        while(s < e){
            int mid = (s + e) / 2;
            if (list.get(mid) <= target) s = mid + 1;
            else e = mid;
        }
        return s;
    }
}
