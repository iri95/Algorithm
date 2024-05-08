package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1826_연료채우기 {
    static class Gas implements Comparable<Gas> {
        int point;
        int gas;

        public Gas(int point, int gas) {
            this.point = point;
            this.gas = gas;
        }

        public int compareTo(Gas g) {
            return this.point - g.point;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Gas> gases = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            gases.add(new Gas(p, g));
            sum += g;
        }
        Collections.sort(gases);
        Queue<Gas> pq = new PriorityQueue<>((o1, o2) -> o2.gas - o1.gas);
        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        gases.add(new Gas(L, 0));
        if (P >= L) {
            System.out.println(0);
            return;
        } else if (P + sum < L) {
            System.out.println(-1);
            return;
        }
        int index = 0;
        int answer = 0;
        while (index < N) {
            if (P >= L) break;
            while (index < N && P >= gases.get(index).point)
                pq.add(gases.get(index++));

            if (pq.isEmpty()) {
                answer = -1;
                break;
            }

            while (!pq.isEmpty() && P < gases.get(index).point) {
                P += pq.poll().gas;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
