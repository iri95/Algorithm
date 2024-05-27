package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class bj1655_가운데를말해요 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> highPq = new PriorityQueue<>();
        Queue<Integer> lowPq = new PriorityQueue<>(Collections.reverseOrder());
        lowPq.add(Integer.parseInt(br.readLine()));
        sb.append(lowPq.peek()).append("\n");
        for (int i = 2; i <= N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                if (lowPq.peek() >= value) {
                    lowPq.add(value);
                    highPq.add(lowPq.poll());
                } else highPq.add(value);
            } else {
                if (lowPq.peek() <= value) {
                    highPq.add(value);
                    lowPq.add(highPq.poll());
                } else lowPq.add(value);

            }
            sb.append(lowPq.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
