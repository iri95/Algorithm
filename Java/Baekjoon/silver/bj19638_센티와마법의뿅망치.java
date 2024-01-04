package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj19638_센티와마법의뿅망치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        while (queue.peek() >= H) {
            if(queue.peek() <= 1)break;
            queue.add(queue.poll() / 2);
            cnt++;
            if(T == cnt)break;
        }
        if (queue.peek() >= H) {
            System.out.println("NO");
            System.out.println(queue.peek());
        } else {
            System.out.println("YES");
            System.out.println(cnt);
        }
    }
}
