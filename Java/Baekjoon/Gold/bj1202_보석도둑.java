package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// https://steady-coding.tistory.com/56
public class bj1202_보석도둑 {
    static class Gem implements Comparable<Gem> {
        int gram;
        int price;

        public Gem(int gram, int price) {
            this.gram = gram;
            this.price = price;
        }

        @Override
        public int compareTo(Gem o) {
            if (o.gram == this.gram){
                return o.price - this.price;
            }
            return this.gram - o.gram;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Gem[] gems = new Gem[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            gems[i] = new Gem(M, V);
        }
        Arrays.sort(gems);
        int[] gramC = new int[K];
        for (int i = 0; i < K; i++) {
            gramC[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(gramC);
        Queue<Integer> temp = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int i = 0, j = 0; i < K; i++) {
            while(j < N && gems[j].gram <= gramC[i]) temp.add(gems[j++].price);
            if (!temp.isEmpty()) sum += temp.poll();
        }
        System.out.println(sum);
    }
}
