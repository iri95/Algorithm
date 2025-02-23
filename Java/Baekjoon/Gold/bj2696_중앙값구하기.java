package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2696_중앙값구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            Queue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Integer> minPQ = new PriorityQueue<>();
            int M = Integer.parseInt(br.readLine());
            sb.append(M / 2 + 1).append("\n");
            int count = 0;
            for (int i = 0; i < M; i++) {
                if (i % 10 == 0) st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                if (maxPQ.size() == minPQ.size()) {
                    maxPQ.add(n);
                    if (!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
                        int max = maxPQ.poll();
                        int min = minPQ.poll();
                        maxPQ.add(min);
                        minPQ.add(max);
                    }
                    sb.append(maxPQ.peek()).append(" ");
                    if (++count % 10 == 0) sb.append("\n");
                } else minPQ.add(n);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
