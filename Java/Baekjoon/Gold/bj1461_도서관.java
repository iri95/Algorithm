package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1461_도서관 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Integer> minus = new PriorityQueue<>();
        Queue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        boolean isMax = false; // false 면 minus
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (max < Math.abs(k)) {
                isMax = k >= 0;
                max = Math.abs(k);
            }
            if (k < 0) minus.offer(k);
            else if (k > 0) plus.offer(k);
        }
        int result = 0;
        int cnt = 0;
        if (isMax) {
            while (!minus.isEmpty()) {
                if (cnt % M == 0) result += Math.abs(minus.poll() * 2);
                else minus.remove();
                cnt++;
            }
            cnt = 1;
            result += Math.abs(plus.poll());
            while (!plus.isEmpty()) {
                if (cnt % M == 0) result += Math.abs(plus.poll() * 2);
                else plus.remove();
                cnt++;
            }
        }else{
            while (!plus.isEmpty()) {
                if (cnt % M == 0)  result += Math.abs(plus.poll() * 2);
                else plus.remove();
                cnt++;
            }
            cnt = 1;
            result += Math.abs(minus.poll());
            while (!minus.isEmpty()) {
                if (cnt % M == 0) result += Math.abs(minus.poll() * 2);
                else minus.remove();
                cnt++;
            }
        }
        System.out.println(result);
    }
}
