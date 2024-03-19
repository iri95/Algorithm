package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1781_컵라면 {
    static class Ramen implements Comparable<Ramen> {
        int deadLine;
        int ramen;

        public Ramen(int deadLine, int ramen) {
            this.deadLine = deadLine;
            this.ramen = ramen;
        }

        public int compareTo(Ramen o) {
            return o.ramen - this.ramen;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Ramen[] ramens = new Ramen[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            ramens[i] = new Ramen(deadLine, ramen);
        }
        Arrays.sort(ramens, Comparator.comparingInt(o -> o.deadLine));
        Queue<Ramen> queue = new PriorityQueue<>();
        int index = N - 1;
        int deadLine = N;
        int answer = 0;
        while (deadLine > 0) {
            while (index >= 0) {
                if (ramens[index].deadLine >= deadLine) {
                    queue.add(ramens[index]);
                    index--;
                }else {
                    break;
                }
            }
            if (!queue.isEmpty())answer += queue.poll().ramen;
            deadLine--;
        }
        System.out.println(answer);
    }
}
